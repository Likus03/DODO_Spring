package by.it.academy.dodo.repositories.menu;

import by.it.academy.dodo.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link Menu} entities.
 */
public interface MenuRepository extends JpaRepository<Menu, UUID> {
    /**
     * Retrieves a list of {@link Menu} entities based on a search parameter that matches the 'name' or 'describe' fields.
     *
     * @param parameter The search parameter.
     * @return An optional list of {@link Menu} entities matching the search parameter.
     */
    @NonNull
    @Query(value = "select * from menus where name||describe ilike %:param%", nativeQuery = true)
    Optional<List<Menu>> findByParameter(@Nullable @Param("param") String parameter);
}
