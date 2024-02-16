package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerRepositoryCustom {
    List<Worker> findByWorkerType(String workerType);

    boolean updateWorker(UUID id, Worker newWorker);
}
