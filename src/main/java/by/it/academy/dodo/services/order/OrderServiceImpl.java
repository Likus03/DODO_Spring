package by.it.academy.dodo.services.order;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.OrderMapper;
import by.it.academy.dodo.repositories.menu.MenuRepository;
import by.it.academy.dodo.repositories.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final MongoTemplate mongoTemplate;
    private final MenuRepository menuRepository;


    @Transactional(readOnly = true)
    @Override
    public List<OrderResponseDto> getOrdersByStatus(ObjectId workerId, boolean isCompleted) throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorker_IdAndIsCompleted(workerId, isCompleted);

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orderMapper.mapToOrderDtoList(orders);
//        return null;

    }

    @Transactional
    @Override
    public List<OrderResponseDto> getAvailableOrders() throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorkerIsNull();

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orderMapper.mapToOrderDtoList(orders);
    }

    @Transactional
    @Override
    public boolean getOrder(ObjectId orderId, ObjectId workerId) throws ClientInvalidDataException {
        Query query = new Query().addCriteria(where("_id").is(orderId)
                .and("worker").is(null));

        Update update = new Update().set("worker", workerId);
        return mongoTemplate.updateFirst(query, update, Order.class).getMatchedCount() == 1;
    }

    @Transactional
    @Override
    public boolean createOrder(OrderRequestDto orderRequestDTO) throws DataIntegrityViolationException {
        Order order = orderMapper.mapToOder(orderRequestDTO);
        if (order.getDeliveryTime() == null) {
            order.setDeliveryTime(LocalDateTime.now());
        }

        calculateTotalCost(order);
        return saveOrder(order);
    }

    @Override
    @Transactional
    public boolean saveOrder(Order order) throws DataIntegrityViolationException {
        try {
            orderRepository.save(order);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save order");
        }
    }

    @Transactional
    @Override
    public boolean completeOrder(ObjectId id) {
        Query query = new Query().addCriteria(where("_id").is(id)
                .and("worker").exists(true));

        Update update = new Update().set("isCompleted", true);
        return mongoTemplate.updateFirst(query, update, Order.class).getMatchedCount() == 1;
    }

    @Override
    public void calculateTotalCost(Order order) {
        order.setTotalCost(order.getMenu().stream()
                .map(Menu::getId)
                .map(id -> menuRepository.findById(id).orElseThrow(ClientInvalidDataException::new))
                .map(Menu::getCost)
                .reduce(ZERO, BigDecimal::add));
    }
}
