package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerRequestDTO> readAll();
    List<WorkerRequestDTO> readBySearch(String parameter);
    boolean update(UUID id, WorkerRequestDTO worker);
    Worker findById(UUID id);
}
