package by.it.academy.dodo.services.order;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.OrderMapper;
import by.it.academy.dodo.repositories.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional(readOnly = true)
    @Override
    public List<OrderResponseDto> getOrdersByStatus(UUID workerId, boolean isCompleted) throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorker_IdAndIsCompleted(workerId, isCompleted);

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orderMapper.mapToOrderDtoList(orders);
    }

    @Transactional
    @Override
    public List<OrderResponseDto> getAvailableOrders() throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorker_Id(null);

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orderMapper.mapToOrderDtoList(orders);
    }

    @Transactional
    @Override
    public boolean getOrder(UUID orderId, UUID workerId) {
        return orderRepository.getOrder(orderId, workerId);
    }

    @Transactional
    @Override
    public boolean createOrder(OrderRequestDto orderRequestDTO) throws DataIntegrityViolationException {
        Order order = orderMapper.mapToOder(orderRequestDTO);
        if (order.getDeliveryTime() == null) {
            order.setDeliveryTime(LocalDateTime.now());
        }
        return saveOrder(order);
    }

    @Override
    @Transactional
    public boolean saveOrder(Order order) throws DataIntegrityViolationException {
        try {
            orderRepository.saveAndFlush(order);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save order");
        }
    }

    @Transactional
    @Override
    public boolean completeOrder(UUID id) {
        return orderRepository.completeOrder(id);
    }
}
