package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    /**
     * Retrieves a list of workers based on the provided parameter.
     *
     * @param parameter The parameter to search for in worker details.
     * @return A list of {@link WorkerDto}.
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    List<WorkerDto> getWorkersByFirstname(String parameter);

    List<WorkerDto> getWorkersByPhoneNumber(String phoneNumber);

    List<WorkerDto> getWorkersBySurname(String surname);

    List<WorkerDto> getWorkersByWorkerType(String workerType);

    /**
     * Updates the worker with the specified ID using the provided {@link WorkerDto}.
     *
     * @param id               The ID of the worker to update.
     * @param workerDTO The updated worker data.
     * @return {@code true} if the worker is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the worker data is invalid or not found.
     */
    boolean updateWorker(UUID id, WorkerDto workerDTO);

    /**
     * Saves the provided worker to the repository.
     *
     * @param worker The worker to save.
     * @return {@code true} if the worker is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the worker data is invalid.
     */
    boolean saveWorker(Worker worker);
}
