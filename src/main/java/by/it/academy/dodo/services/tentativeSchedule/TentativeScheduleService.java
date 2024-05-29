package by.it.academy.dodo.services.tentativeSchedule;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.entities.TentativeSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;

public interface TentativeScheduleService {
    /**
     * Creates a new tentative schedule for the specified worker.
     *
     * @param idWorker             The ID of the worker.
     * @param tentativeScheduleDTO The tentative schedule data to create.
     * @return {@code true} if the tentative schedule is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the tentative schedule data is invalid.
     */
    boolean createTentativeSchedule(ObjectId idWorker, TentativeScheduleDto tentativeScheduleDTO);

    /**
     * Saves the provided tentative schedule to the repository.
     *
     * @param tentativeSchedule The tentative schedule to save.
     * @return {@code true} if the tentative schedule is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean saveTentativeSchedule(TentativeSchedule tentativeSchedule);

    /**
     * Updates the tentative schedule with the specified ID using the provided {@link TentativeScheduleDto}.
     *
     * @param id                   The ID of the tentative schedule to update.
     * @param tentativeScheduleDTO The updated tentative schedule data.*/
    void updateTentativeSchedule(ObjectId id, TentativeScheduleDto tentativeScheduleDTO);

    /**
     * Retrieves the tentative schedule for the specified worker for the given week.
     *
     * @param idWorker The ID of the worker.
     * @param date     The date within the week for which the tentative schedule is requested.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    List<TentativeScheduleDto> getWeekTentativeSchedule(ObjectId idWorker, LocalDate date);

    /**
     * Retrieves the tentative schedule for the specified date.
     *
     * @param date The date for which the tentative schedule is requested.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    List<TentativeScheduleDto> getDayTentativeSchedule(LocalDate date);

    /**
     * Deletes the tentative schedule with the specified ID.
     *
     * @param id The ID of the tentative schedule to delete.
     */
    void deleteTentativeSchedule(ObjectId id);
}
