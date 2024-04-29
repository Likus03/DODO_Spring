package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.entities.Menu;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    /**
     * Creates a new menu based on the provided {@link DishDto}.
     *
     * @param menuRequestDTO The menu data to create.
     * @return {@code true} if the menu is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean createDish(DishDto menuRequestDTO);

    /**
     * Saves the provided menu to the repository.
     *
     * @param menu The menu to save.
     * @return {@code true} if the menu is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    boolean saveDish(Menu menu);

    /**
     * Retrieves all menu.
     *
     * @return A list of all menu.
     */
    List<DishDto> getMenu();

    @Transactional(readOnly = true)
    @Cacheable(value = "menu", key = "#id")
    DishDto getMenuById(UUID id);

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
     * @return {@code true} if the menu is deleted successfully, {@code false} otherwise.
     */
    boolean deleteDish(UUID id);

    /**
     * Updates the menu with the specified ID using the provided {@link DishDto}.
     *
     * @param id      The ID of the menu to update.
     * @param dishDTO The updated menu data.
     * @return {@code true} if the menu is updated successfully, {@code false} otherwise.
     */
    boolean updateDish(UUID id, DishDto dishDTO);

    /**
     * Retrieves dishes based by name.
     *
     * @param description The parameter to search for in menu description.
     * @return A list of dishes matching the specified description.
     */
    List<DishDto> getDishByDescription(String description);
}
