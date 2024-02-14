package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting between {@link UserRequestDTO} and {@link User}.
 */
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a {@link UserRequestDTO} to a {@link User} entity.
     *
     * @param userRequestDTO The {@link UserRequestDTO} to convert.
     * @return The corresponding {@link User} entity.
     */
    User createUser(UserRequestDTO userRequestDTO);

    /**
     * Converts a {@link User} entity to a {@link UserRequestDTO}.
     *
     * @param user The {@link User} entity to convert.
     * @return The corresponding {@link UserRequestDTO}.
     */
    UserRequestDTO createUserDTO(User user);
}
