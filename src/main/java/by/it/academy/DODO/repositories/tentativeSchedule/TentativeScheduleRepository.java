package by.it.academy.DODO.repositories.tentativeSchedule;

import by.it.academy.DODO.entities.TentativeSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link TentativeSchedule} entities.
 */
public interface TentativeScheduleRepository extends JpaRepository<TentativeSchedule, UUID> {

    /**
     * Retrieves a list of {@link TentativeSchedule} entities based on the worker's ID and a date range.
     *
     * @param id              The ID of the worker.
     * @param dateStartWeek   The start date of the week.
     * @param dateEndWeek     The end date of the week.
     * @return An optional list of {@link TentativeSchedule} entities matching the worker's ID and date range.
     */
    @NonNull
    Optional<List<TentativeSchedule>> findAllByWorkerIdAndDateWorkBetween(@NonNull UUID id, @NonNull LocalDate dateStartWeek, @NonNull LocalDate dateEndWeek);
    /**
     * Retrieves a list of {@link TentativeSchedule} entities based on a specific date.
     *
     * @param dateWork The date to retrieve tentative schedules for.
     * @return A list of {@link TentativeSchedule} entities for the specified date.
     */
    @NonNull
    Optional<List<TentativeSchedule>> findAllByDateWork(@NonNull LocalDate dateWork);
}
