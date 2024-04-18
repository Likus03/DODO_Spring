package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryCustomImpl implements MenuRepositoryCustom {

    private final MongoOperations mongoTemplate;

    @Override
    public boolean updateDish(ObjectId id, Menu newDish) {
//        long updateCount = jpaQueryFactory.update(menu)
//                .set(menu.name, newDish.getName())
//                .set(menu.description, newDish.getDescription())
//                .set(menu.cost, newDish.getCost())
//                .where(menu.id.eq(id))
//                .execute();
//
//        return updateCount > 0;
        return true;
    }

    @Override
    public boolean deleteDish(ObjectId id) {
//        long deleteCount = jpaQueryFactory.delete(menu)
//                .where(menu.id.eq(id))
//                .execute();
//
//        return deleteCount > 0;
        return true;
    }
}
