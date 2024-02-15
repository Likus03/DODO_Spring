package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Mapper interface for converting between {@link MenuDTO} and {@link Menu}.
 */
@Component
@Mapper(componentModel = "spring")
public interface MenuMapper {

    /**
     * Converts a {@link MenuDTO} to a {@link Menu}.
     *
     * @param menuDTO The {@link MenuDTO} to convert.
     * @return The corresponding {@link Menu} entity.
     */
    Menu createMenu(MenuDTO menuDTO);

    /**
     * Converts a {@link Menu} entity to a {@link MenuDTO}.
     *
     * @param menu The {@link Menu} entity to convert.
     * @return The corresponding {@link MenuDTO}.
     */
    MenuDTO createMenuDTO(Menu menu);

    /**
     * Converts a list of {@link Menu} entity to a list of {@link MenuDTO}.
     * @param menus The list of {@link Menu} entity to convert.
     * @return The corresponding list of {@link MenuDTO}.
     */
    List<MenuDTO> createMenuDTOList(List<Menu> menus);
}