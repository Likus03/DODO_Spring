package by.it.academy.dodo.repositories.workSchedule;

import by.it.academy.dodo.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
/**
 * Repository interface for performing CRUD operations on {@link WorkSchedule} entities.
 */
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, UUID>, WorkScheduleRepositoryCustom{
    /**
     * Finds work schedules for a specific date.
     *
     * @param dateWork The date for which work schedules should be retrieved.
     * @return An optional list of {@link WorkSchedule} containing the specified date.
     */
    List<WorkSchedule> findAllByWorkDate(LocalDate dateWork);
    /**
     * Finds work schedules for a date range between startWeek and endWeek.
     *
     * @param startWeek The start date of the week.
     * @param endWeek   The end date of the week.
     * @return An optional list of {@link WorkSchedule} containing the specified date range.
     */
    List<WorkSchedule> findAllByWorkDateBetween(LocalDate startWeek, LocalDate endWeek);
}
