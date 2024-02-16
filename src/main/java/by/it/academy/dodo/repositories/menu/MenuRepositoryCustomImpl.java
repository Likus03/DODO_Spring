package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QMenu.menu;

public class MenuRepositoryCustomImpl extends QuerydslRepositorySupport implements MenuRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public MenuRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Menu.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean updateDish(UUID id, Menu newDish) {
        long updateCount = jpaQueryFactory.update(menu)
                .set(menu.name, newDish.getName())
                .set(menu.description, newDish.getDescription())
                .set(menu.cost, newDish.getCost())
                .where(menu.id.eq(id))
                .execute();

        return updateCount > 0;
    }

    @Override
    public boolean deleteDish(UUID id) {
        long deleteCount = jpaQueryFactory.delete(menu)
                .where(menu.id.eq(id))
                .execute();

        return deleteCount > 0;
    }
}
