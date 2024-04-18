package by.it.academy.dodo.repositories.tentativeSchedule;

import by.it.academy.dodo.entities.TentativeSchedule;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Custom implementation of additional operations for the TentativeScheduleRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
@Repository
@RequiredArgsConstructor
public class TentativeScheduleRepositoryCustomImpl implements TentativeScheduleRepositoryCustom {
    private final MongoOperations mongoTemplate;


    @Override
    public boolean deleteTentativeSchedule(ObjectId id) {
//        long deleteCount = jpaQueryFactory.delete(tentativeSchedule)
//                .where(tentativeSchedule.id.eq(id))
//                .execute();
//
//        return deleteCount > 0;
        return true;
    }

    @Override
    public boolean updateTentativeSchedule(ObjectId id, TentativeSchedule newTentativeSchedule) {
//        long updateCount = jpaQueryFactory.update(tentativeSchedule)
//                .set(tentativeSchedule.startTime, newTentativeSchedule.getStartTime())
//                .set(tentativeSchedule.endTime, newTentativeSchedule.getEndTime())
//                .where(tentativeSchedule.id.eq(id))
//                .execute();
//
//        return updateCount > 0;
        return true;
    }
}
