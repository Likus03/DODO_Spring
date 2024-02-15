package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.entities.WorkSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link WorkScheduleRequestDTO}, {@link WorkScheduleResponseDTO}, and {@link WorkSchedule}.
 */
@Component
@Mapper(componentModel = "spring")
public interface WorkScheduleMapper {
    /**
     * Converts a {@link WorkSchedule} entity to a {@link WorkScheduleResponseDTO}.
     *
     * @param workSchedule The {@link WorkSchedule} entity to convert.
     * @return The corresponding {@link WorkScheduleResponseDTO}.
     */
    WorkScheduleResponseDTO createWorkScheduleDTO(WorkSchedule workSchedule);
    /**
     * Converts a {@link WorkScheduleRequestDTO} to a {@link WorkSchedule} entity.
     *
     * @param workScheduleRequestDTO The {@link WorkScheduleRequestDTO} to convert.
     * @return The corresponding {@link WorkSchedule} entity.
     */
    WorkSchedule createWorkSchedule(WorkScheduleRequestDTO workScheduleRequestDTO);

    /**
     * Converts a list of {@link WorkSchedule} entity to a list of {@link WorkScheduleResponseDTO}.
     * @param workSchedules The list of {@link WorkSchedule} entity to convert.
     * @return The corresponding list of {@link WorkScheduleResponseDTO}.
     */
    List<WorkScheduleResponseDTO> createWorkScheduleDTOList(List<WorkSchedule> workSchedules);
}
