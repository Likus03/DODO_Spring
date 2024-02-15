package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerDto> getWorkersByParameter(String parameter);
    boolean updateWorker(UUID id, WorkerDto workerDTO);
    boolean saveWorker(Worker worker);
}
