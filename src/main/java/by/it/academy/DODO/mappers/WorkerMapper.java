package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkerMapper {
    WorkerDTO createWorkerDTO(Worker worker);
    Worker createWorker(WorkerDTO request);
}
