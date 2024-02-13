package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean createTentativeSchedule(UUID idWorker, TentativeScheduleDTO tentativeScheduleDTO);
    boolean saveTentativeSchedule(TentativeSchedule tentativeSchedule);
    boolean updateTentativeSchedule(UUID id, TentativeScheduleDTO tentativeScheduleDTO);
    List<TentativeScheduleDTO> getWeekTentativeSchedule(UUID idWorker, LocalDate date);
    List<TentativeScheduleDTO> getDayTentativeSchedule(LocalDate date);
    boolean deleteTentativeSchedule(UUID id);
}
