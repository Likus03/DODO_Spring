package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkerMapper {
    WorkerRequestDTO createWorkerDTO(Worker worker);
    Worker createWorker(WorkerRequestDTO workerRequestDTO);
}
