package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.entities.Menu;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    /**
     * Creates a new menu based on the provided {@link DishDto}.
     *
     * @param menuRequestDTO The menu data to create.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    void createDish(DishDto menuRequestDTO);

    /**
     * Retrieves all menu.
     *
     * @return A list of all menu.
     */
    List<DishDto> getMenu();

    /**
     * Retrieves dishes based by name.
     *
     * @param name The parameter to search for in menu names.
     * @return A list of dishes matching the specified name.
     */
    List<DishDto> getDishByName(String name);

    /**
     * Deletes the menu with the specified ID.
     *
     * @param id The ID of the menu to delete.
     */
    void deleteDish(ObjectId id);

    /**
     * Updates the menu with the specified ID using the provided {@link DishDto}.
     *
     * @param id      The ID of the menu to update.
     * @param dishDTO The updated menu data.
     */
    void updateDish(ObjectId id, DishDto dishDTO);

    /**
     * Retrieves dishes based by name.
     *
     * @param description The parameter to search for in menu description.
     * @return A list of dishes matching the specified description.
     */
    List<DishDto> getDishByDescription(String description);
}
