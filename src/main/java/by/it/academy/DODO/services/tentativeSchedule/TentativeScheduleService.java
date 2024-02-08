package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.response.tentativeSchedule.TentativeScheduleResponseDTO;
import by.it.academy.DODO.entities.TentativeSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean create(UUID idWorker, TentativeScheduleResponseDTO request);
    boolean update(UUID id, TentativeScheduleResponseDTO request);
    List<TentativeScheduleResponseDTO> readWeekScheduleByIdWorker(UUID idWorker, LocalDate localDate);
    List<TentativeScheduleResponseDTO> readDaySchedule(LocalDate date);
    TentativeSchedule findById(UUID id);
    boolean delete(UUID id);
    boolean update(TentativeScheduleResponseDTO tentativeScheduleResponseDTO);
}
