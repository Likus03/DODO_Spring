package by.it.academy.dodo.repositories.tentativeSchedule;

import by.it.academy.dodo.entities.TentativeSchedule;

import java.util.UUID;

public interface TentativeScheduleRepositoryCustom {
    boolean deleteTentativeSchedule(UUID id);

    boolean updateTentativeSchedule(UUID id, TentativeSchedule newTentativeSchedule);
}
