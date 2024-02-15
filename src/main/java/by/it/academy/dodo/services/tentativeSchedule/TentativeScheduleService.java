package by.it.academy.dodo.services.tentativeSchedule;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.entities.TentativeSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean createTentativeSchedule(UUID idWorker, TentativeScheduleDto tentativeScheduleDTO);
    boolean saveTentativeSchedule(TentativeSchedule tentativeSchedule);
    boolean updateTentativeSchedule(UUID id, TentativeScheduleDto tentativeScheduleDTO);
    List<TentativeScheduleDto> getWeekTentativeSchedule(UUID idWorker, LocalDate date);
    List<TentativeScheduleDto> getDayTentativeSchedule(LocalDate date);
    boolean deleteTentativeSchedule(UUID id);
}
