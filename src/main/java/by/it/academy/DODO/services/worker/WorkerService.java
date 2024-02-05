package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<WorkerDTO> readAll();
    List<WorkerDTO> readBySearch(String parameter);
    boolean update(UUID id, WorkerDTO worker);
    Worker findById(UUID id);
}
