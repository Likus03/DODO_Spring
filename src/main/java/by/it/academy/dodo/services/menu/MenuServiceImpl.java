package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.MenuMapper;
import by.it.academy.dodo.repositories.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public boolean createDish(DishDto menuRequestDTO) throws DataIntegrityViolationException {
        Menu menu = menuMapper.mapToMenu(menuRequestDTO);
        return saveDish(menu);
    }

    @Override
    @Transactional
    public boolean saveDish(Menu dish) throws DataIntegrityViolationException {
        try {
            menuRepository.saveAndFlush(dish);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save dish");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishDto> getMenu() {
        return getDishDto(menuRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishDto> getDishByName(String name) {
        return getDishDto(menuRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DishDto> getDishByDescription(String description) {
        return getDishDto(menuRepository.findByDescriptionContainingIgnoreCase(description));
    }

    @Override
    @Transactional
    public boolean deleteDish(UUID id) {
        return menuRepository.deleteDish(id);
    }

    @Override
    @Transactional
    public boolean updateDish(UUID id, DishDto dishDTO) {
        Menu newMenu = menuMapper.mapToMenu(dishDTO);
        return menuRepository.updateDish(id, newMenu);
    }

    /**
     * Helper method to map a list of menus to a list of menu DTOs.
     *
     * @param menus The list of menus to map.
     * @return A list of menu DTOs.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    private List<DishDto> getDishDto(List<Menu> menus) throws ClientInvalidDataException {
        if (menus.isEmpty()) {
            throw new ClientInvalidDataException("Dish was not found");
        }
        return menuMapper.mapToDishDtoList(menus);
    }
}
