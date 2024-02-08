package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.response.menu.MenuResponseDTO;
import by.it.academy.DODO.entities.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MenuMapper {
    Menu createMenu(MenuResponseDTO menuResponseDTO);
}
