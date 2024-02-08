package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;
import by.it.academy.DODO.mappers.MenuMapper;
import by.it.academy.DODO.repositories.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;

    @Override
    public boolean create(MenuDTO menuRequestDTO) {
        Menu menu = menuMapper.createMenu(menuRequestDTO);
        menuRepository.save(menu);
        return true;
    }

    @Override
    public List<MenuDTO> get() {
        return menuRepository.findAll().stream()
                .map(menuMapper::createMenuDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(UUID id) {
        try {
            menuRepository.deleteById(id);
        } catch (DataAccessException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UUID id, MenuDTO menuDTO) {
        Menu newMenu = menuMapper.createMenu(menuDTO);
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        if(optionalMenu.isPresent()){
            Menu oldMenu = optionalMenu.get();
            setUpdatingMenu(newMenu, oldMenu);
            menuRepository.save(oldMenu);
            return true;
        }
        return false;
    }

    private void setUpdatingMenu(Menu newMenu, Menu oldMenu) {
        oldMenu.setName(newMenu.getName());
        oldMenu.setDescribe(newMenu.getDescribe());
        oldMenu.setCost(newMenu.getCost());
    }
}
