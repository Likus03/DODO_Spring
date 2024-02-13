package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.entities.User;

import java.util.UUID;

public interface UserService {
    boolean createUser(UserWorkerRequestDTO userWorkerRequestDTO);
    boolean saveUser(User user);
    boolean updateUser(UUID idWorker, UserRequestDTO userRequestDTO);
    boolean deleteUser(UUID id);
}
