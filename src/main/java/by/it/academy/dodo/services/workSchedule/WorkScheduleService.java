package by.it.academy.dodo.services.workSchedule;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.entities.WorkSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface WorkScheduleService {
    /**
     * Creates a new work schedule for the specified worker.
     *
     * @param workerId               The ID of the worker.
     * @param workScheduleRequestDTO The request DTO containing the work schedule details.
     * @return {@code true} if the work schedule is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the work schedule data is invalid or not found.
     */
    boolean createWorkSchedule(UUID workerId, WorkScheduleRequestDto workScheduleRequestDTO);

    /**
     * Saves the provided work schedule to the repository.
     *
     * @param workSchedule The work schedule to save.
     * @return {@code true} if the work schedule is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean saveWorkSchedule(WorkSchedule workSchedule);

    /**
     * Retrieves a list of work schedules for the specified date.
     *
     * @param workDate The date for which to retrieve work schedules.
     * @return A list of {@link WorkScheduleResponseDto}.
     * @throws ClientInvalidDataException If the work schedule data is invalid or not found.
     */
    List<WorkScheduleResponseDto> getDayWorkSchedule(LocalDate workDate);

    /**
     * Retrieves a list of work schedules for the specified date range.
     *
     * @param startWork The start date of the date range.
     * @param endWork   The end date of the date range.
     * @return A list of {@link WorkScheduleResponseDto}.
     * @throws ClientInvalidDataException If the work schedule data is invalid or not found.
     */
    List<WorkScheduleResponseDto> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork);

    /**
     * Deletes the work schedule with the specified ID.
     *
     * @param id The ID of the work schedule to delete.
     * @return {@code true} if the work schedule is deleted successfully, {@code false} otherwise.
     */
    boolean deleteWorkSchedule(UUID id);
}
