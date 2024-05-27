package by.it.academy.dodo.repositories.order;

import by.it.academy.dodo.entities.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link Order} entities.
 */
public interface OrderRepository extends MongoRepository<Order, ObjectId>{

    /**
     * Retrieves a list of {@link Order} entities based on the worker's ID and completion status.
     *
     * @param workerId  The ID of the worker.
     * @param completed The completion status.
     * @return An optional list of {@link Order} entities matching the worker's ID and completion status.
     */

    List<Order> findAllByWorker_IdAndIsCompleted(ObjectId workerId, Boolean completed);
    List<Order> findAllByWorkerIsNull();
}
