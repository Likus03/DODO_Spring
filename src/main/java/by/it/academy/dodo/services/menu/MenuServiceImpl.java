package by.it.academy.dodo.services.menu;

import by.it.academy.dodo.dto.MenuDto;
import by.it.academy.dodo.entities.Menu;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.MenuMapper;
import by.it.academy.dodo.repositories.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;
    /**
     * Creates a new menu based on the provided {@link MenuDto}.
     *
     * @param menuRequestDTO The menu data to create.
     * @return {@code true} if the menu is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     */
    @Override
    @Transactional
    public boolean createMenu(MenuDto menuRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (menuRequestDTO != null) {
            Menu menu = menuMapper.createMenu(menuRequestDTO);
            return saveMenu(menu);
        }
        throw new ClientInvalidDataException("Unable to create menu");
    }
    /**
     * Saves the provided menu to the repository.
     *
     * @param menu The menu to save.
     * @return {@code true} if the menu is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     */
    @Override
    @Transactional
    public boolean saveMenu(Menu menu) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (menu != null) {
            try {
                menuRepository.saveAndFlush(menu);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save client");
            }
        }
        throw new ClientInvalidDataException("Unable to save menu");
    }
    /**
     * Retrieves all menus.
     *
     * @return A list of all menus.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MenuDto> getAllMenu() throws ClientInvalidDataException {
        List<Menu> menus = menuRepository.findAll();

        return getMenuDTOS(menus);
    }
    /**
     * Retrieves menus based on the specified parameter.
     *
     * @param parameter The parameter to search for in menu names and descriptions.
     * @return A list of menus matching the specified parameter.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MenuDto> getMenuByParameter(String parameter) throws ClientInvalidDataException {
        List<Menu> menus = menuRepository.findByParameter(parameter).orElse(Collections.emptyList());

        return getMenuDTOS(menus);
    }
    /**
     * Helper method to map a list of menus to a list of menu DTOs.
     *
     * @param menus The list of menus to map.
     * @return A list of menu DTOs.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    private List<MenuDto> getMenuDTOS(List<Menu> menus) throws ClientInvalidDataException{
        if (menus != null) {
            if (menus.isEmpty()) {
                throw new ClientInvalidDataException("Menu was not found");
            }
            return menuMapper.createMenuDTOList(menus);

        }
        throw new ClientInvalidDataException("Unable to get menu");
    }
    /**
     * Deletes the menu with the specified ID.
     *
     * @param id The ID of the menu to delete.
     * @return {@code true} if the menu is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the menu data is invalid.
     */
    @Override
    @Transactional
    public boolean deleteMenu(UUID id) throws ClientInvalidDataException {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("The requested menu was not found"));
        menuRepository.delete(menu);
        return true;
    }
    /**
     * Updates the menu with the specified ID using the provided {@link MenuDto}.
     *
     * @param id      The ID of the menu to update.
     * @param menuDTO The updated menu data.
     * @return {@code true} if the menu is updated successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException      If the menu data is invalid.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    @Override
    @Transactional
    public boolean updateMenu(UUID id, MenuDto menuDTO) throws ClientInvalidDataException, DataIntegrityViolationException {
        if (menuDTO != null) {
            Menu newMenu = menuMapper.createMenu(menuDTO);
            Optional<Menu> optionalMenu = menuRepository.findById(id);
            if (optionalMenu.isPresent()) {
                Menu oldMenu = optionalMenu.get();
                setUpdatingMenu(newMenu, oldMenu);
                return saveMenu(oldMenu);
            }
            throw new ClientInvalidDataException("Menu was not found");
        }
        throw new ClientInvalidDataException("Unable to update menu");
    }
    /**
     * Sets up the updating of the menu with new menu data.
     *
     * @param newMenu The new menu data.
     * @param oldMenu The existing menu data.
     */
    private void setUpdatingMenu(Menu newMenu, Menu oldMenu) {
        oldMenu.setName(newMenu.getName());
        oldMenu.setDescribe(newMenu.getDescribe());
        oldMenu.setCost(newMenu.getCost());
    }
}
