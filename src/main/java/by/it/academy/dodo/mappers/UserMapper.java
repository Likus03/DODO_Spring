package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting between {@link UserRequestDto} and {@link User}.
 */
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Converts a {@link UserRequestDto} to a {@link User} entity.
     *
     * @param userRequestDTO The {@link UserRequestDto} to convert.
     * @return The corresponding {@link User} entity.
     */
    User mapToUser(UserRequestDto userRequestDTO);
    User mapToUser(UserRequestPutDto userRequestPutDto);
}
