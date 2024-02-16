package by.it.academy.dodo;

import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.services.menu.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MenuServiceTest {
    private final MenuService menuService;

    @Autowired
    public MenuServiceTest(MenuService menuService) {
        this.menuService = menuService;
    }

    @Test
    @Transactional
    public void testDeleteNonExistingDishById() {
        assertFalse(menuService.deleteDish(UUID.randomUUID()));
    }

    @Test
    @Transactional
    public void testSaveDishInvalidData() {
        assertThrows(DataIntegrityViolationException.class, () ->
                menuService.saveDish(new Menu()));
    }
}
