package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.entities.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Mapper interface for converting between {@link DishDto} and {@link Menu}.
 */
@Component
@Mapper(componentModel = "spring")
public interface MenuMapper {

    /**
     * Converts a {@link DishDto} to a {@link Menu}.
     *
     * @param dishDTO The {@link DishDto} to convert.
     * @return The corresponding {@link Menu} entity.
     */
    Menu mapToMenu(DishDto dishDTO);
    DishDto mapToMenuDto(Menu dish);

    /**
     * Converts a list of {@link Menu} entity to a list of {@link DishDto}.
     * @param dishes The list of {@link Menu} entity to convert.
     * @return The corresponding list of {@link DishDto}.
     */
    List<DishDto> mapToDishDtoList(List<Menu> dishes);

}