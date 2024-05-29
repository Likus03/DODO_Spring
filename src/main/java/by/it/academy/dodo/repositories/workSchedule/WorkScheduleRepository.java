package by.it.academy.dodo.repositories.workSchedule;

import by.it.academy.dodo.entities.WorkSchedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
/**
 * Repository interface for performing CRUD operations on {@link WorkSchedule} entities.
 */
public interface WorkScheduleRepository extends MongoRepository<WorkSchedule, ObjectId>, WorkScheduleRepositoryCustom{
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
