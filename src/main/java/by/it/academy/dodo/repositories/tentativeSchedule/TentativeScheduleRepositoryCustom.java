package by.it.academy.dodo.repositories.tentativeSchedule;

import by.it.academy.dodo.entities.TentativeSchedule;

import java.util.UUID;

public interface TentativeScheduleRepositoryCustom {

    /**
     * Deletes a tentative schedule with the specified ID.
     *
     * @param id The ID of the tentative schedule to be deleted.
     * @return True if the tentative schedule is deleted successfully, false otherwise.
     */
    boolean deleteTentativeSchedule(UUID id);

    /**
     * Updates a tentative schedule with the specified ID.
     *
     * @param id       The ID of the tentative schedule to be updated.
     * @param newTentativeSchedule The updated tentative schedule object.
     * @return True if the tentative schedule is updated successfully, false otherwise.
     */
    boolean updateTentativeSchedule(UUID id, TentativeSchedule newTentativeSchedule);
}
