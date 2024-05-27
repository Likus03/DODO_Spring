package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on {@link Menu} entities.
 */
public interface MenuRepository extends MongoRepository<Menu, ObjectId> {
    /**
     * Retrieves a list of {@link Menu} entities based on a search parameter that matches the 'name' or 'describe' fields.
     *
     * @param name The search parameter.
     * @return An optional list of {@link Menu} entities matching the search parameter.
     */
    List<Menu> findByNameContainingIgnoreCase(String name);
    List<Menu> findByDescriptionContainingIgnoreCase(String description);
}
