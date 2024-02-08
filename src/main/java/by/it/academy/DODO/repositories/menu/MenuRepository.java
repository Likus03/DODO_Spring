package by.it.academy.DODO.repositories.menu;

import by.it.academy.DODO.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {
}
