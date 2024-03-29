package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;

import java.util.UUID;

public interface MenuRepositoryCustom {

    /**
     * Updates a dish with the specified ID.
     *
     * @param id       The ID of the dish to be updated.
     * @param newDish The updated dish object.
     * @return True if the dish is updated successfully, false otherwise.
     */
    boolean updateDish(UUID id, Menu newDish);

    /**
     * Deletes a dish with the specified ID.
     *
     * @param id The ID of the dish to be deleted.
     * @return True if the dish is deleted successfully, false otherwise.
     */
    boolean deleteDish(UUID id);
}
