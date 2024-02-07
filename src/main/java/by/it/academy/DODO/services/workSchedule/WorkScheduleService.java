package by.it.academy.DODO.services.workSchedule;

import by.it.academy.DODO.dto.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.WorkScheduleResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface WorkScheduleService {
    boolean createWorkSchedule(WorkScheduleRequestDTO workScheduleRequestDTO);
    List<WorkScheduleResponseDTO> getDayWorkSchedule(LocalDate dateWork);
    List<WorkScheduleResponseDTO> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork);
    boolean deleteWorkSchedule(UUID id);
}
