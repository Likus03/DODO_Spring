package by.it.academy.dodo;

import by.it.academy.dodo.dto.MenuDto;
import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.MenuMapper;
import by.it.academy.dodo.services.menu.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

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
        assertThrows(DataIntegrityViolationException.class, () ->
                menuService.createMenu(new MenuDto()));
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
                menuService.deleteMenu(UUID.randomUUID()));
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
                menuService.updateMenu(UUID.randomUUID(), menuMapper.createMenuDTO(
                        new Menu(
                                UUID.fromString("8c3905bd-0f13-4a06-874a-162890d25856"),
                                "gavai", "Signature alfredo sauce, chicken, mozzarella, pineapples",
                                18.99f,
                                new ArrayList<>()))));

        assertThrows(DataIntegrityViolationException.class, () ->
                menuService.updateMenu(UUID.fromString("8c3905bd-0f13-4a06-874a-162890d25856"), new MenuDto()));
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
                menuService.saveMenu(new Menu()));
    }
}
