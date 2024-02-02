package by.it.academy.DODO.services.user;

import by.it.academy.DODO.entities.User;

import java.util.UUID;

public interface UserService {
    boolean create(User user);
    boolean update(User user);
    boolean delete(UUID id);
    User getLoggedUser(String login, String password);
}
