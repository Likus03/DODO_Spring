package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerRepositoryCustom {

    /**
     * Finds workers by worker type, ignoring case.
     *
     * @param workerType The worker type to search for.
     * @return List of workers matching the specified worker type.
     */
    List<Worker> findByWorkerType(String workerType);

    /**
     * Updates a worker with the specified ID.
     *
     * @param id       The ID of the worker to be updated.
     * @param newWorker The updated worker object.
     * @return True if the worker is updated successfully, false otherwise.
     */
    boolean updateWorker(UUID id, Worker newWorker);
}
