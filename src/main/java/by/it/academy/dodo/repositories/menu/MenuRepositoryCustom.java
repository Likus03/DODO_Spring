package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;

import java.util.UUID;

public interface MenuRepositoryCustom {
    boolean updateDish(UUID id, Menu newDish);
    boolean deleteDish(UUID id);
}
