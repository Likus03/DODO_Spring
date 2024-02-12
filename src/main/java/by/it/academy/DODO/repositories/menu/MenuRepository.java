package by.it.academy.DODO.repositories.menu;

import by.it.academy.DODO.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
    @NonNull
    @Query(value = "select * from menus where name||describe ilike %:param%", nativeQuery = true)
    Optional<List<Menu>> findByParameter(@Nullable @Param("param") String parameter);
}
