package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    /**
     * Retrieves a list of {@link WorkerDto} based by firstname.
     *
     * @param firstname The parameter to search for in worker by firstname.
     * @return A list of {@link WorkerDto}.
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    List<WorkerDto> getWorkersByFirstname(String firstname);

    /**
     * Retrieves a list of {@link WorkerDto} based by phone number.
     *
     * @param phoneNumber The parameter to search for in worker by phone number.
     * @return A list of {@link WorkerDto}.
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    List<WorkerDto> getWorkersByPhoneNumber(String phoneNumber);

    /**
     * Retrieves a list of {@link WorkerDto} based by surname.
     *
     * @param surname The parameter to search for in worker by surname.
     * @return A list of {@link WorkerDto}.
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    List<WorkerDto> getWorkersBySurname(String surname);

    /**
     * Retrieves a list of {@link WorkerDto} based by worker type.
     *
     * @param workerType The parameter to search for in worker by worker type.
     * @return A list of {@link WorkerDto}.
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    List<WorkerDto> getWorkersByWorkerType(String workerType);

    /**
     * Updates the worker with the specified ID using the provided {@link WorkerDto}.
     *
     * @param id        The ID of the worker to update.
     * @param workerDTO The updated worker data.
     * @return {@code true} if the worker is updated successfully, {@code false} otherwise.
     */
    boolean updateWorker(UUID id, WorkerDto workerDTO);
}
