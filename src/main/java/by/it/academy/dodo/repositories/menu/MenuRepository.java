package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link Menu} entities.
 */
public interface MenuRepository extends JpaRepository<Menu, UUID>, MenuRepositoryCustom {
    /**
     * Retrieves a list of {@link Menu} entities based on a search parameter that matches the 'name' or 'describe' fields.
     *
     * @param parameter The search parameter.
     * @return An optional list of {@link Menu} entities matching the search parameter.
     */
    List<Menu> findByNameContainingIgnoreCase(String name);

    List<Menu> findByDescriptionContainingIgnoreCase(String description);
}
