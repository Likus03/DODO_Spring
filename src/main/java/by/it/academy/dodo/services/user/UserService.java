package by.it.academy.dodo.services.user;

import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.entities.User;

import java.util.UUID;

public interface UserService {
    boolean createUser(UserWorkerRequestDto userWorkerRequestDTO);
    boolean saveUser(User user);
    boolean updateUser(UUID idWorker, UserRequestDto userRequestDTO);
    boolean deleteUser(UUID id);
}
