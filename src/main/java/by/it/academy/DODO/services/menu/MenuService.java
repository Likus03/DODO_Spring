package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.response.menu.MenuResponseDTO;

public interface MenuService {
    boolean create(MenuResponseDTO menuRequestDTO);
}
