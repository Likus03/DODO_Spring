package by.it.academy.dodo.repositories.user;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
/**
 * Custom implementation of additional operations for the UserRepository.
 * This class extends QuerydslRepositorySupport to leverage Querydsl in custom repository methods.
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final MongoOperations mongoTemplate;

    @Override
    public boolean deleteUser(ObjectId id) {
//        long deleteCount = jpaQueryFactory.delete(user)
//                .where(user.worker.id.eq(id))
//                .execute();
//
//        return deleteCount > 0;
        return true;
    }

    @Override
    public boolean updateUserPassword(ObjectId workerId, String password) {
//        long updateCount = jpaQueryFactory.update(user)
//                .set(user.password, password)
//                .where(user.worker.id.eq(workerId))
//                .execute();
//
//        return updateCount > 0;
        return true;
    }


}
