package by.it.academy.dodo.repositories.order;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Custom implementation of additional operations for the OrderRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {

    private final MongoOperations mongoTemplate;

    @Override
    public boolean getOrder(ObjectId orderId, ObjectId workerId) {
//        mongoTemplate.update()
//        long updateCount = jpaQueryFactory.update(order)
//                .set(order.worker.id, workerId)
//                .where(order.id.eq(orderId))
//                .where(order.worker.id.isNull())
//                .execute();
//
//        return updateCount > 0;
        return true;
    }

    @Override
    public boolean completeOrder(ObjectId id) {
//        long updateCount = jpaQueryFactory.update(order)
//                .set(order.isCompleted, true)
//                .where(order.id.eq(id))
//                .where(order.worker.id.isNotNull())
//                .execute();
//
//        return updateCount > 0;
        return true;
    }


}
