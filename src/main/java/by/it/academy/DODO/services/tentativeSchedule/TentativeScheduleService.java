package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.entities.TentativeSchedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public interface TentativeScheduleService {
    boolean addTentativeSchedule(UUID idWorker, LocalDate dateWork, LocalTime startTime, LocalTime endTime);
    List<TentativeSchedule> readTentativeScheduleById(UUID idWorker, LocalDate date);
    LocalDate getMaxDate(UUID idWorker);
    boolean AddEmptySchedule(UUID idWorker, LocalDate now);
}
