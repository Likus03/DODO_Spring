package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    boolean create(MenuDTO menuRequestDTO);

    boolean save(Menu menu);

    List<MenuDTO> get();

    boolean delete(UUID id);

    boolean update(UUID id, MenuDTO menuDTO);

    List<MenuDTO> getByParameter(String parameter);
}
