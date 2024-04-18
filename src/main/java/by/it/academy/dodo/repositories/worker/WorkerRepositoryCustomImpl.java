package by.it.academy.dodo.repositories.worker;

import by.it.academy.dodo.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
/**
 * Custom implementation of additional operations for the WorkerRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
@Repository
@RequiredArgsConstructor
public class WorkerRepositoryCustomImpl implements WorkerRepositoryCustom {
    private final MongoOperations mongoTemplate;

    @Override
    public List<Worker> findByWorkerType(String workerType) {
//        return jpaQueryFactory.selectFrom(worker)
//                .where(worker.workerType.stringValue().likeIgnoreCase("%" + workerType + "%"))
//                .fetch();
        return null;
    }

    @Override
    public boolean updateWorker(UUID id, Worker newWorker) {
//        long updateCount = jpaQueryFactory.update(worker)
//                .set(worker.firstname, newWorker.getFirstname())
//                .set(worker.surname, newWorker.getSurname())
//                .set(worker.phoneNumber, newWorker.getPhoneNumber())
//                .set(worker.workerType, newWorker.getWorkerType())
//                .where(worker.id.eq(id))
//                .execute();
//
//        return updateCount > 0;
        return true;
    }
}
