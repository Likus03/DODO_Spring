package by.it.academy.dodo.repositories.tentativeSchedule;

import by.it.academy.dodo.entities.TentativeSchedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QTentativeSchedule.tentativeSchedule;
/**
 * Custom implementation of additional operations for the TentativeScheduleRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
public class TentativeScheduleRepositoryCustomImpl extends QuerydslRepositorySupport implements TentativeScheduleRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public TentativeScheduleRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(TentativeSchedule.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean deleteTentativeSchedule(UUID id) {
        long deleteCount = jpaQueryFactory.delete(tentativeSchedule)
                .where(tentativeSchedule.id.eq(id))
                .execute();

        return deleteCount > 0;
    }

    @Override
    public boolean updateTentativeSchedule(UUID id, TentativeSchedule newTentativeSchedule) {
        long updateCount = jpaQueryFactory.update(tentativeSchedule)
                .set(tentativeSchedule.startTime, newTentativeSchedule.getStartTime())
                .set(tentativeSchedule.endTime, newTentativeSchedule.getEndTime())
                .where(tentativeSchedule.id.eq(id))
                .execute();

        return updateCount > 0;
    }
}
