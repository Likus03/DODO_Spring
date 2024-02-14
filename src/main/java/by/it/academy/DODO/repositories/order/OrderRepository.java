package by.it.academy.DODO.repositories.order;

import by.it.academy.DODO.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link Order} entities.
 */
public interface OrderRepository extends JpaRepository<Order, UUID> {

    /**
     * Retrieves a list of {@link Order} entities based on the worker's ID and completion status.
     *
     * @param worker_id  The ID of the worker.
     * @param completed The completion status.
     * @return An optional list of {@link Order} entities matching the worker's ID and completion status.
     */
    @NonNull
    Optional<List<Order>> findAllByWorker_IdAndCompleted(@Nullable UUID worker_id, @NonNull Boolean completed);
}
