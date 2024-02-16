package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link WorkerDto} and {@link Worker}.
 */
@Component
@Mapper(componentModel = "spring")
public interface WorkerMapper {
    /**
     * Converts a {@link Worker} entity to a {@link WorkerDto}.
     *
     * @param worker The {@link Worker} entity to convert.
     * @return The corresponding {@link WorkerDto}.
     */
    WorkerDto mapToWorkerDto(Worker worker);
    /**
     * Converts a {@link WorkerDto} to a {@link Worker} entity.
     *
     * @param workerDTO The {@link WorkerDto} to convert.
     * @return The corresponding {@link Worker} entity.
     */
    Worker mapToWorker(WorkerDto workerDTO);

    /**
     * Converts a list of {@link Worker} entity to a list of {@link WorkerDto}.
     * @param workers menus The list of {@link Worker} entity to convert.
     * @return The corresponding list of {@link WorkerDto}.
     */
    List<WorkerDto> mapToWorkerDtoList(List<Worker> workers);

}
