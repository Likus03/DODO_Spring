package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    boolean createMenu(MenuDTO menuRequestDTO);
    boolean saveMenu(Menu menu);
    List<MenuDTO> getAllMenu();
    List<MenuDTO> getMenuByParameter(String parameter);
    boolean deleteMenu(UUID id);
    boolean updateMenu(UUID id, MenuDTO menuDTO);
}
