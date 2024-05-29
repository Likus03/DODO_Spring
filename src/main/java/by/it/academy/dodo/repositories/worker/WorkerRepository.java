package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on {@link Worker} entities.
 */
public interface WorkerRepository extends MongoRepository<Worker, ObjectId> {
    /**
     * Finds workers based on a search parameter that may match fields like firstname, phone_number, surname, and worker_type.
     *
     * @param firstname The search parameter to match against worker fields.
     * @return An optional list of {@link Worker} containing matching the search parameter.
     */
    List<Worker> findByFirstnameContainingIgnoreCase(String firstname);

    List<Worker> findByPhoneNumberContaining(String phoneNumber);

    List<Worker> findBySurnameContainingIgnoreCase(String surname);

}
