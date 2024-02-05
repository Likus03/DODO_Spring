package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean create(UUID idWorker, TentativeScheduleDTO request);

    boolean update(UUID id, TentativeScheduleDTO request);

    List<TentativeSchedule> read(UUID idWorker, LocalDate date);
    TentativeSchedule findById(UUID id);
    boolean delete(UUID id);
    boolean update(TentativeScheduleDTO tentativeScheduleDTO);
}
