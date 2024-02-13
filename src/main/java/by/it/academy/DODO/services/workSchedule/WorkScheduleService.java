package by.it.academy.DODO.services.workSchedule;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.entities.WorkSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface WorkScheduleService {
    boolean createWorkSchedule(UUID idWorker, WorkScheduleRequestDTO workScheduleRequestDTO);
    boolean saveWorkSchedule(WorkSchedule workSchedule);
    List<WorkScheduleResponseDTO> getDayWorkSchedule(LocalDate dateWork);
    List<WorkScheduleResponseDTO> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork);
    boolean deleteWorkSchedule(UUID id);
}
