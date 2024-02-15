package by.it.academy.dodo.services.workSchedule;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.entities.WorkSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface WorkScheduleService {
    boolean createWorkSchedule(UUID idWorker, WorkScheduleRequestDto workScheduleRequestDTO);
    boolean saveWorkSchedule(WorkSchedule workSchedule);
    List<WorkScheduleResponseDto> getDayWorkSchedule(LocalDate dateWork);
    List<WorkScheduleResponseDto> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork);
    boolean deleteWorkSchedule(UUID id);
}
