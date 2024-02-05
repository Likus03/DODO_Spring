package by.it.academy.DODO.services.order;

import by.it.academy.DODO.dto.OrderDTO;
import by.it.academy.DODO.entities.Order;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.mappers.OrderMapper;
import by.it.academy.DODO.repositories.order.OrderRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WorkerRepository workerRepository;
    private final OrderMapper orderMapper;
    @Transactional(readOnly = true)
    @Override
    public List<OrderDTO> getOrdersByParameters(UUID id, boolean completed) {
        Optional<List<Order>> optionalOrders = orderRepository.findAllByWorker_IdAndCompleted(id, completed);

        if (optionalOrders.isPresent()) {
            List<Order> orders = optionalOrders.get();
            return orders.stream()
                    .map(orderMapper::createOrderDTO)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Transactional
    @Override
    public boolean takeOrder(UUID idOrder, UUID idWorker) {
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        Optional<Worker> optionalWorker = workerRepository.findById(idOrder);

        if (optionalOrder.isPresent() && optionalWorker.isPresent()) {
            Order order = optionalOrder.get();
            Worker worker = optionalWorker.get();
            order.setWorker(worker);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

//    @Transactional
//    @Override
//    public boolean create(OrderDTO request) {
//
//        Order order = orderMapper.createUser(request);
//        try {
//            orderRepository.save(order);
//        } catch (DataAccessException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    @Transactional
    @Override
    public boolean completeOrder(UUID id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setCompleted(true);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

//    @Transactional(readOnly = true)
//    @Override
//    public Order findById(UUID id) {
//        return orderRepository.findById(id).orElse(null);
//    }
}
