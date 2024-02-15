package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.MenuDto;
import by.it.academy.dodo.entities.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Mapper interface for converting between {@link MenuDto} and {@link Menu}.
 */
@Component
@Mapper(componentModel = "spring")
public interface MenuMapper {

    /**
     * Converts a {@link MenuDto} to a {@link Menu}.
     *
     * @param menuDTO The {@link MenuDto} to convert.
     * @return The corresponding {@link Menu} entity.
     */
    Menu createMenu(MenuDto menuDTO);

    /**
     * Converts a {@link Menu} entity to a {@link MenuDto}.
     *
     * @param menu The {@link Menu} entity to convert.
     * @return The corresponding {@link MenuDto}.
     */
    MenuDto createMenuDTO(Menu menu);

    /**
     * Converts a list of {@link Menu} entity to a list of {@link MenuDto}.
     * @param menus The list of {@link Menu} entity to convert.
     * @return The corresponding list of {@link MenuDto}.
     */
    List<MenuDto> createMenuDTOList(List<Menu> menus);

}