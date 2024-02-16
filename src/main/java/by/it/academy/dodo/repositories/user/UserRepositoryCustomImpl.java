package by.it.academy.dodo.repositories.user;

import by.it.academy.dodo.entities.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QUser.user;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean deleteUser(UUID id) {
        long deleteCount = jpaQueryFactory.delete(user)
                .where(user.worker.id.eq(id))
                .execute();

        return deleteCount > 0;
    }

    @Override
    public boolean updateUserPassword(UUID workerId, String password) {
        long updateCount = jpaQueryFactory.update(user)
                .set(user.password, password)
                .where(user.worker.id.eq(workerId))
                .execute();

        return updateCount > 0;
    }


}
