package by.it.academy.DODO;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.MenuMapper;
import by.it.academy.DODO.services.menu.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MenuServiceTests {
    private final MenuService menuService;
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceTests(MenuService menuService, MenuMapper menuMapper) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @Test
    @Transactional
    public void testCreate() {
        assertThrows(DataIntegrityViolationException.class, () -> {
                    menuService.create(new MenuDTO());
                }
        );
    }

    @Test
    @Transactional
    public void deleteTest() {
        assertThrows(ClientInvalidDataException.class, () -> {
            menuService.delete(UUID.randomUUID());
        });
    }

    @Test
    @Transactional
    public void testUpdateWithoutId() {
        boolean realResult = menuService.update(UUID.randomUUID(), menuMapper.createMenuDTO(new Menu(UUID.fromString("8c3905bd-0f13-4a06-874a-162890d25856"), "gavai", "Signature alfredo sauce, chicken, mozzarella, pineapples", 18.99f, new ArrayList<>())));
        assertFalse(realResult);

        assertThrows(DataIntegrityViolationException.class, () ->
        {
            menuService.update(UUID.fromString("8c3905bd-0f13-4a06-874a-162890d25856"), new MenuDTO());
        });
    }
}
