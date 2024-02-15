package by.it.academy.dodo;

import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.UserMapper;
import by.it.academy.dodo.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTests {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceTests(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Test
    @Transactional
    public void testCreate() {
        assertThrows(ClientInvalidDataException.class, () ->
                userService.createUser(new UserWorkerRequestDto()));
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
                userService.saveUser(new User()));
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
                userService.updateUser(UUID.randomUUID(),
                        userMapper.createUserDTO(new User(
                                "fjid",
                                "ju9393dj"
                        ))));

        assertThrows(DataIntegrityViolationException.class, () ->
                userService.updateUser(UUID.fromString("7d614120-0ea9-4935-bd5f-d47619d6248a"), new UserRequestDto()));
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
                userService.deleteUser(UUID.randomUUID()));
    }
}
