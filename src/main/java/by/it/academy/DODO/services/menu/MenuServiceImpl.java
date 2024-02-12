package by.it.academy.DODO.services.menu;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.MenuMapper;
import by.it.academy.DODO.repositories.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;

    @Override
    @Transactional
    public boolean create(MenuDTO menuRequestDTO) throws DataIntegrityViolationException{
        Menu menu = menuMapper.createMenu(menuRequestDTO);
        return save(menu);
    }

    @Override
    @Transactional
    public boolean save(Menu menu) throws DataIntegrityViolationException{
        try {
            menuRepository.saveAndFlush(menu);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save client");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuDTO> get() throws ClientInvalidDataException {
        List<Menu> menus = menuRepository.findAll();
        if (menus.isEmpty()) {
            throw new ClientInvalidDataException("Menu information not found");
        }
        return menus.stream()
                .map(menuMapper::createMenuDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean delete(UUID id) throws ClientInvalidDataException{
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("The requested menu was not found"));
        menuRepository.delete(menu);
        return true;
    }

    @Override
    @Transactional
    public boolean update(UUID id, MenuDTO menuDTO) throws ClientInvalidDataException, DataIntegrityViolationException{
        Menu newMenu = menuMapper.createMenu(menuDTO);
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        if (optionalMenu.isPresent()) {
            Menu oldMenu = optionalMenu.get();
            setUpdatingMenu(newMenu, oldMenu);
            return save(oldMenu);
        }
        throw new ClientInvalidDataException("Menu was not found");
    }

    private void setUpdatingMenu(Menu newMenu, Menu oldMenu) {
        oldMenu.setName(newMenu.getName());
        oldMenu.setDescribe(newMenu.getDescribe());
        oldMenu.setCost(newMenu.getCost());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuDTO> getByParameter(String parameter) throws ClientInvalidDataException{
        List<Menu> menus = menuRepository.findByParameter(parameter).orElse(Collections.emptyList());

        if(menus.isEmpty()){
            throw new ClientInvalidDataException("Menu was not found");
        }
        return menus.stream()
                .map(menuMapper::createMenuDTO)
                .toList();
    }
}
