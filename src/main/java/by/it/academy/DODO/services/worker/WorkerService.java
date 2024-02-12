package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerRequestDTO> getByParameter(String parameter);
    boolean update(UUID id, WorkerRequestDTO worker);
    boolean save(Worker oldWorker);
}
