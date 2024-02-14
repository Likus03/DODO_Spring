package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting between {@link WorkerRequestDTO} and {@link Worker}.
 */
@Component
@Mapper(componentModel = "spring")
public interface WorkerMapper {
    /**
     * Converts a {@link Worker} entity to a {@link WorkerRequestDTO}.
     *
     * @param worker The {@link Worker} entity to convert.
     * @return The corresponding {@link WorkerRequestDTO}.
     */
    WorkerRequestDTO createWorkerDTO(Worker worker);
    /**
     * Converts a {@link WorkerRequestDTO} to a {@link Worker} entity.
     *
     * @param workerRequestDTO The {@link WorkerRequestDTO} to convert.
     * @return The corresponding {@link Worker} entity.
     */
    Worker createWorker(WorkerRequestDTO workerRequestDTO);
}
