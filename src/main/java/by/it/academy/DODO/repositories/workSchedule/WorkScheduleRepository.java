package by.it.academy.DODO.repositories.workSchedule;

import by.it.academy.DODO.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link WorkSchedule} entities.
 */
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, UUID> {
    /**
     * Finds work schedules for a specific date.
     *
     * @param dateWork The date for which work schedules should be retrieved.
     * @return An optional list of {@link WorkSchedule} containing the specified date.
     */
    Optional<List<WorkSchedule>> findAllByDateWork(LocalDate dateWork);
    /**
     * Finds work schedules for a date range between startWeek and endWeek.
     *
     * @param startWeek The start date of the week.
     * @param endWeek   The end date of the week.
     * @return An optional list of {@link WorkSchedule} containing the specified date range.
     */
    Optional<List<WorkSchedule>> findAllByDateWorkBetween(LocalDate startWeek, LocalDate endWeek);
}
