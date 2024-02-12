package by.it.academy.DODO.services.order;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.entities.Order;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.OrderMapper;
import by.it.academy.DODO.repositories.order.OrderRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
    public List<OrderResponseDTO> getOrdersByParameters(UUID id, boolean completed) throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorker_IdAndCompleted(id, completed)
                .orElse(Collections.emptyList());

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orders.stream()
                .map(orderMapper::createOrderDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public boolean takeOrder(UUID idOrder, UUID idWorker) throws DataIntegrityViolationException{
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        Optional<Worker> optionalWorker = workerRepository.findById(idWorker);

        if (optionalOrder.isPresent() && optionalWorker.isPresent()) {
            Order order = optionalOrder.get();
            Worker worker = optionalWorker.get();
            order.setWorker(worker);
            return save(order);
        }
        return false;
    }

    @Transactional
    @Override
    public boolean create(OrderRequestDTO orderRequestDTO) throws DataIntegrityViolationException{
        Order order = orderMapper.createOder(orderRequestDTO);
        return save(order);
    }

    @Override
    @Transactional
    public boolean save(Order order) throws DataIntegrityViolationException {
        try {
            orderRepository.saveAndFlush(order);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save order");
        }
    }

    @Transactional
    @Override
    public boolean completeOrder(UUID id) throws ClientInvalidDataException, DataIntegrityViolationException {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setCompleted(true);
            return save(order);

        }
        throw new ClientInvalidDataException("Order was not found");
    }
}
