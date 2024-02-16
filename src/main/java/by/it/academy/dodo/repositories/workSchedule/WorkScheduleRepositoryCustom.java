package by.it.academy.dodo.repositories.workSchedule;

import java.util.UUID;

public interface WorkScheduleRepositoryCustom {

    /**
     * Deletes a work schedule with the specified ID.
     *
     * @param id The ID of the work schedule to be deleted.
     * @return True if the work schedule is deleted successfully, false otherwise.
     */
    boolean deleteWorkSchedule(UUID id);
}
