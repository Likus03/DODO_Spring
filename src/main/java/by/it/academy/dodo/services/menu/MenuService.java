package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.MenuDto;
import by.it.academy.dodo.entities.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    boolean createMenu(MenuDto menuRequestDTO);
    boolean saveMenu(Menu menu);
    List<MenuDto> getAllMenu();
    List<MenuDto> getMenuByParameter(String parameter);
    boolean deleteMenu(UUID id);
    boolean updateMenu(UUID id, MenuDto menuDTO);
}
