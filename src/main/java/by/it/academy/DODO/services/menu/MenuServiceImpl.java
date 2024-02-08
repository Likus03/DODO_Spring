package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.response.menu.MenuResponseDTO;
import by.it.academy.DODO.entities.Menu;
import by.it.academy.DODO.mappers.MenuMapper;
import by.it.academy.DODO.repositories.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;
    @Override
    public boolean create(MenuResponseDTO menuRequestDTO) {
        Menu menu = menuMapper.createMenu(menuRequestDTO);
        menuRepository.save(menu);
        return true;
    }
}
