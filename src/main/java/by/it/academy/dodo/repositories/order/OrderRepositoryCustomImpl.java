package by.it.academy.dodo.repositories.order;

import by.it.academy.dodo.entities.Order;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QOrder.order;
/**
 * Custom implementation of additional operations for the OrderRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
public class OrderRepositoryCustomImpl extends QuerydslRepositorySupport implements OrderRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public OrderRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Order.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean getOrder(UUID orderId, UUID workerId) {
        long updateCount = jpaQueryFactory.update(order)
                .set(order.worker.id, workerId)
                .where(order.id.eq(orderId))
                .execute();

        return updateCount > 0;
    }

    @Override
    public boolean completeOrder(UUID id) {
        long updateCount = jpaQueryFactory.update(order)
                .set(order.completed, true)
                .where(order.id.eq(id))
                .execute();

        return updateCount > 0;
    }
}
