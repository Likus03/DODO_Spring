package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.entities.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


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
}