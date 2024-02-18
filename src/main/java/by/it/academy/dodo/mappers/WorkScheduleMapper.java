package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.entities.WorkSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link WorkScheduleRequestDto}, {@link WorkScheduleResponseDto}, and {@link WorkSchedule}.
 */
@Component
@Mapper(componentModel = "spring")
public interface WorkScheduleMapper {
    /**
     * Converts a {@link WorkScheduleRequestDto} to a {@link WorkSchedule} entity.
     *
     * @param workScheduleRequestDTO The {@link WorkScheduleRequestDto} to convert.
     * @return The corresponding {@link WorkSchedule} entity.
     */
    WorkSchedule mapToWorkSchedule(WorkScheduleRequestDto workScheduleRequestDTO);

    /**
     * Converts a list of {@link WorkSchedule} entity to a list of {@link WorkScheduleResponseDto}.
     * @param workSchedules The list of {@link WorkSchedule} entity to convert.
     * @return The corresponding list of {@link WorkScheduleResponseDto}.
     */
    List<WorkScheduleResponseDto> mapToWorkScheduleDtoList(List<WorkSchedule> workSchedules);
}
