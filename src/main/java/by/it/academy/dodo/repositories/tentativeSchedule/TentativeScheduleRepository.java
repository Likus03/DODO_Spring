package by.it.academy.dodo.repositories.tentativeSchedule;

import by.it.academy.dodo.entities.TentativeSchedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link TentativeSchedule} entities.
 */
public interface TentativeScheduleRepository extends MongoRepository<TentativeSchedule, ObjectId>, TentativeScheduleRepositoryCustom {
    /**
     * Retrieves a list of {@link TentativeSchedule} entities based on the worker's ID and a date range.
     *
     * @param id            The ID of the worker.
     * @param dateStartWeek The start date of the week.
     * @param dateEndWeek   The end date of the week.
     * @return An optional list of {@link TentativeSchedule} entities matching the worker's ID and date range.
     */
//    List<TentativeSchedule> findAllByWorkerIdAndWorkDateBetween(UUID id, LocalDate dateStartWeek, LocalDate dateEndWeek);
//
//    /**
//     * Retrieves a list of {@link TentativeSchedule} entities based on a specific date.
//     *
//     * @param dateWork The date to retrieve tentative schedules for.
//     * @return A list of {@link TentativeSchedule} entities for the specified date.
//     */
//    List<TentativeSchedule> findAllByWorkDate(LocalDate dateWork);
}
