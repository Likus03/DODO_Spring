package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link WorkerDTO} and {@link Worker}.
 */
@Component
@Mapper(componentModel = "spring")
public interface WorkerMapper {
    /**
     * Converts a {@link Worker} entity to a {@link WorkerDTO}.
     *
     * @param worker The {@link Worker} entity to convert.
     * @return The corresponding {@link WorkerDTO}.
     */
    WorkerDTO createWorkerDTO(Worker worker);
    /**
     * Converts a {@link WorkerDTO} to a {@link Worker} entity.
     *
     * @param workerDTO The {@link WorkerDTO} to convert.
     * @return The corresponding {@link Worker} entity.
     */
    Worker createWorker(WorkerDTO workerDTO);

    /**
     * Converts a list of {@link Worker} entity to a list of {@link WorkerDTO}.
     * @param workers menus The list of {@link Worker} entity to convert.
     * @return The corresponding list of {@link WorkerDTO}.
     */
    List<WorkerDTO> createWorkerDTOList(List<Worker> workers);
}
