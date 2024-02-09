package by.it.academy.DODO.services.order;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.entities.Order;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.EmptyObjectException;
import by.it.academy.DODO.mappers.OrderMapper;
import by.it.academy.DODO.repositories.order.OrderRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
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
    public List<OrderResponseDTO> getOrdersByParameters(UUID id, boolean completed) throws EmptyObjectException {
        List<Order> orders = orderRepository.findAllByWorker_IdAndCompleted(id, completed)
                .orElseThrow(() -> new NoSuchElementException(id.toString() + " " + completed));

        if (orders.isEmpty()) {
            throw new EmptyObjectException(id.toString() + " " + completed);
        }

        return orders.stream()
                .map(orderMapper::createOrderDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean takeOrder(UUID idOrder, UUID idWorker) {
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        Optional<Worker> optionalWorker = workerRepository.findById(idWorker);

        if (optionalOrder.isPresent() && optionalWorker.isPresent()) {
            Order order = optionalOrder.get();
            Worker worker = optionalWorker.get();
            order.setWorker(worker);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean create(OrderRequestDTO orderRequestDTO) {

        Order order = orderMapper.createOder(orderRequestDTO);

        try {
            orderRepository.save(order);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean completeOrder(UUID id) throws EmptyObjectException{
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setCompleted(true);
            orderRepository.save(order);
            return true;
        }
        throw new EmptyObjectException(id.toString());
    }
}
