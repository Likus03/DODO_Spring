package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.UserDTO;
import by.it.academy.DODO.dto.UserWorkerDTO;
import by.it.academy.DODO.entities.User;

import java.util.UUID;

public interface UserService {
    boolean create(UserWorkerDTO request);
    boolean update(UserDTO userDTO);
    boolean delete(UUID id);
    User getLoggedUser(String login, String password);
}
