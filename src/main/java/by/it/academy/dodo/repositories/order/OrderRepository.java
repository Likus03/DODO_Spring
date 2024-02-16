package by.it.academy.dodo.repositories.order;

import by.it.academy.dodo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link Order} entities.
 */
public interface OrderRepository extends JpaRepository<Order, UUID>, OrderRepositoryCustom {

    /**
     * Retrieves a list of {@link Order} entities based on the worker's ID and completion status.
     *
     * @param workerId  The ID of the worker.
     * @param completed The completion status.
     * @return An optional list of {@link Order} entities matching the worker's ID and completion status.
     */

    List<Order> findAllByWorker_IdAndCompleted(UUID workerId, Boolean completed);
    List<Order> findAllByWorker_Id(UUID workerId);
}
