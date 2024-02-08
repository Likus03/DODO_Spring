package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.entities.WorkSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WorkScheduleMapper {
    WorkScheduleResponseDTO createWorkScheduleDTO(WorkSchedule workSchedule);
    WorkSchedule createWorkSchedule(WorkScheduleRequestDTO workScheduleRequestDTO);
}
