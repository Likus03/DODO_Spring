package by.it.academy.dodo.repositories.workSchedule;

import by.it.academy.dodo.entities.WorkSchedule;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QWorkSchedule.workSchedule;

public class WorkScheduleRepositoryCustomImpl extends QuerydslRepositorySupport implements WorkScheduleRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public WorkScheduleRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(WorkSchedule.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean deleteWorkSchedule(UUID id) {
        long deleteCount = jpaQueryFactory.delete(workSchedule)
                .where(workSchedule.id.eq(id))
                .execute();

        return deleteCount > 0;
    }
}
