package by.it.academy.dodo.repositories.workSchedule;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * Custom implementation of additional operations for the WorkScheduleRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
@Repository
@RequiredArgsConstructor
public class WorkScheduleRepositoryCustomImpl implements WorkScheduleRepositoryCustom{
    private final MongoOperations mongoTemplate;

    @Override
    public boolean deleteWorkSchedule(UUID id) {
//        long deleteCount = jpaQueryFactory.delete(workSchedule)
//                .where(workSchedule.id.eq(id))
//                .execute();
//
//        return deleteCount > 0;
        return true;
    }
}
