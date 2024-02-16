package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    /**
     * Creates a new menu based on the provided {@link DishDto}.
     *
     * @param menuRequestDTO The menu data to create.
     * @return {@code true} if the menu is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     */
    boolean createDish(DishDto menuRequestDTO);

    /**
     * Saves the provided menu to the repository.
     *
     * @param menu The menu to save.
     * @return {@code true} if the menu is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     */
    boolean saveDish(Menu menu);

    /**
     * Retrieves all menus.
     *
     * @return A list of all menus.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    List<DishDto> getMenu();

    /**
     * Retrieves menus based on the specified parameter.
     *
     * @param parameter The parameter to search for in menu names and descriptions.
     * @return A list of menus matching the specified parameter.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    List<DishDto> getDishByName(String parameter);

    /**
     * Deletes the menu with the specified ID.
     *
     * @param id The ID of the menu to delete.
     * @return {@code true} if the menu is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    boolean deleteDish(UUID id);

    /**
     * Updates the menu with the specified ID using the provided {@link DishDto}.
     *
     * @param id      The ID of the menu to update.
     * @param dishDTO The updated menu data.
     * @return {@code true} if the menu is updated successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean updateDish(UUID id, DishDto dishDTO);

    List<DishDto> getDishByDescription(String description);
}
