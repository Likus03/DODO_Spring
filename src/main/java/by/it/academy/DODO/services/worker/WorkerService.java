package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerRequestDTO> getWorkersByParameter(String parameter);
    boolean updateWorker(UUID id, WorkerRequestDTO workerRequestDTO);
    boolean saveWorker(Worker worker);
}
