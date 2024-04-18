package by.it.academy.dodo.services.order;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    /**
     * Retrieves a list of orders based on the specified parameters.
     *
     * @param workerId  The ID of the worker.
     * @param isCompleted Indicates whether the orders are isCompleted or not.
     * @return A list of order response DTOs.
     * @throws ClientInvalidDataException If the order data is invalid.
     */
    List<OrderResponseDto> getOrdersByStatus(ObjectId workerId, boolean isCompleted);

    /**
     * Retrieves a list of available orders for workers.
     *
     * @return List of {@link OrderResponseDto} representing available orders.
     * @throws ClientInvalidDataException If no available orders are found.
     */
    List<OrderResponseDto> getAvailableOrders();

    /**
     * Assigns a worker to a specific order.
     *
     * @param idOrder  The ID of the order.
     * @param idWorker The ID of the worker.
     * @return {@code true} if the order is assigned successfully, {@code false} otherwise.
     */
    boolean getOrder(ObjectId idOrder, ObjectId idWorker);

    /**
     * Creates a new order based on the provided {@link OrderRequestDto}.
     *
     * @param orderRequestDTO The order data to create.
     * @return {@code true} if the order is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean createOrder(OrderRequestDto orderRequestDTO);

    /**
     * Saves the provided order to the repository.
     *
     * @param order The order to save.
     * @return {@code true} if the order is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean saveOrder(Order order);

    /**
     * Marks the order with the specified ID as completed.
     *
     * @param id The ID of the order to complete.
     * @return {@code true} if the order is marked as completed successfully, {@code false} otherwise.
     */
    boolean completeOrder(ObjectId id);
}
