package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.MenuDTO;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    boolean create(MenuDTO menuRequestDTO);

    List<MenuDTO> get();

    boolean delete(UUID id);

    boolean update(UUID id, MenuDTO menuDTO);
}
