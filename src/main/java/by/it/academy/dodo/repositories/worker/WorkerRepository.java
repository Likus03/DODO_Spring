package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link Worker} entities.
 */
public interface WorkerRepository extends JpaRepository<Worker, UUID>, WorkerRepositoryCustom {
    /**
     * Finds workers based on a search parameter that may match fields like firstname, phone_number, surname, and worker_type.
     *
     * @param firstname The search parameter to match against worker fields.
     * @return An optional list of {@link Worker} containing matching the search parameter.
     */
    List<Worker> findByFirstnameContainingIgnoreCase(String firstname);
    List<Worker>findByPhoneNumberContaining(String phoneNumber);
    List<Worker>findBySurnameContainingIgnoreCase(String surname);

}
