package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    List<Worker> readAll();
    List<Worker> readBySearch(String parameter);
    boolean update(Worker worker);
    boolean delete(UUID id);
    Worker findById(UUID id);
}
