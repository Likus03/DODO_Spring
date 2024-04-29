package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.UUID;

import static by.it.academy.dodo.entities.QWorker.worker;
/**
 * Custom implementation of additional operations for the WorkerRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
public class WorkerRepositoryCustomImpl extends QuerydslRepositorySupport implements WorkerRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public WorkerRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Worker.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Worker> findByWorkerType(String workerType) {
        return jpaQueryFactory.selectFrom(worker)
                .where(worker.workerType.stringValue().likeIgnoreCase("%" + workerType + "%"))
                .fetch();
    }

    @Override
    public boolean updateWorker(UUID id, Worker newWorker) {
        long updateCount = jpaQueryFactory.update(worker)
                .set(worker.firstname, newWorker.getFirstname())
                .set(worker.surname, newWorker.getSurname())
                .set(worker.phoneNumber, newWorker.getPhoneNumber())
                .set(worker.workerType, newWorker.getWorkerType())
                .where(worker.id.eq(id))
                .execute();

        return updateCount > 0;
    }
}
