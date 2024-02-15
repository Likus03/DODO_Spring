package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerDTO> getWorkersByParameter(String parameter);
    boolean updateWorker(UUID id, WorkerDTO workerDTO);
    boolean saveWorker(Worker worker);
}
