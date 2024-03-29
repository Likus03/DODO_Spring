package by.it.academy.dodo.repositories.order;

import java.util.UUID;

public interface OrderRepositoryCustom {

    /**
     * Assigns a worker to the order with the specified order ID.
     *
     * @param orderId  The ID of the order to be updated.
     * @param workerId The ID of the worker to be assigned to the order.
     * @return True if the order is updated successfully, false otherwise.
     */
    boolean getOrder(UUID orderId, UUID workerId);


    /**
     * Marks the order with the specified ID as completed.
     *
     * @param id The ID of the order to be marked as completed.
     * @return True if the order is marked as completed successfully, false otherwise.
     */
    boolean completeOrder(UUID id);
}
