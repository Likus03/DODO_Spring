package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.TentativeScheduleDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean create(UUID idWorker, TentativeScheduleDTO request);
    boolean update(UUID id, TentativeScheduleDTO request);
    List<TentativeScheduleDTO> readWeekScheduleByIdWorker(UUID idWorker, LocalDate localDate);
    List<TentativeScheduleDTO> readDaySchedule(LocalDate date);
    boolean delete(UUID id);
    boolean update(TentativeScheduleDTO tentativeScheduleDTO);
}
