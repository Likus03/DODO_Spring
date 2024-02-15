package by.it.academy.dodo.services.order;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.OrderMapper;
import by.it.academy.dodo.repositories.order.OrderRepository;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WorkerRepository workerRepository;
    private final OrderMapper orderMapper;
    /**
     * Retrieves a list of orders based on the specified parameters.
     *
     * @param idWorker  The ID of the worker.
     * @param completed Indicates whether the orders are completed or not.
     * @return A list of order response DTOs.
     * @throws ClientInvalidDataException If the order data is invalid.
     */
    @Transactional(readOnly = true)
    @Override
    public List<OrderResponseDto> getOrdersByParameters(UUID idWorker, boolean completed) throws ClientInvalidDataException {
        List<Order> orders = orderRepository.findAllByWorker_IdAndCompleted(idWorker, completed)
                .orElse(Collections.emptyList());

        if (orders.isEmpty()) {
            throw new ClientInvalidDataException("Order was not found");
        }

        return orderMapper.createOrderDTOList(orders);
    }
    /**
     * Assigns a worker to a specific order.
     *
     * @param idOrder  The ID of the order.
     * @param idWorker The ID of the worker.
     * @return {@code true} if the order is assigned successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    @Transactional
    @Override
    public boolean takeOrder(UUID idOrder, UUID idWorker) throws DataIntegrityViolationException {
        Optional<Order> optionalOrder = orderRepository.findById(idOrder);
        Optional<Worker> optionalWorker = workerRepository.findById(idWorker);

        if (optionalOrder.isPresent() && optionalWorker.isPresent()) {
            Order order = optionalOrder.get();
            Worker worker = optionalWorker.get();
            order.setWorker(worker);
            return saveOrder(order);
        }
        return false;
    }
    /**
     * Creates a new order based on the provided {@link OrderRequestDto}.
     *
     * @param orderRequestDTO The order data to create.
     * @return {@code true} if the order is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the order data is invalid.
     */
    @Transactional
    @Override
    public boolean createOrder(OrderRequestDto orderRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (orderRequestDTO != null) {
            Order order = orderMapper.createOder(orderRequestDTO);
            return saveOrder(order);
        }
        throw new ClientInvalidDataException("Unable to create order");
    }
    /**
     * Saves the provided order to the repository.
     *
     * @param order The order to save.
     * @return {@code true} if the order is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the order data is invalid.
     */
    @Override
    @Transactional
    public boolean saveOrder(Order order) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (order != null) {
            try {
                orderRepository.saveAndFlush(order);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save order");
            }
        }
        throw new ClientInvalidDataException("Unable to save order");

    }
    /**
     * Marks the order with the specified ID as completed.
     *
     * @param id The ID of the order to complete.
     * @return {@code true} if the order is marked as completed successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException      If the order data is invalid.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    @Transactional
    @Override
    public boolean completeOrder(UUID id) throws ClientInvalidDataException, DataIntegrityViolationException {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setCompleted(true);
            return saveOrder(order);

        }
        throw new ClientInvalidDataException("Order was not found");
    }
}
