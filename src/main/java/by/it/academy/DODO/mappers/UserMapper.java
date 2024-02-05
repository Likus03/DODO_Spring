package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.UserDTO;
import by.it.academy.DODO.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO createUserDTO(User user);
    User createUser(UserDTO request);
}
