package by.it.academy.dodo;

import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    private final UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    @Transactional
    public void testSaveUserInvalidData() {
        assertThrows(DataIntegrityViolationException.class, () ->
                userService.saveUser(new User()));
    }

    @Test
    @Transactional
    public void testDeleteNonExistingUserById() {
        assertFalse(userService.deleteUser(UUID.randomUUID()));
    }
}
