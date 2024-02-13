package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserRequestDTO userRequestDTO);
    UserRequestDTO createUserDTO(User user);
}
