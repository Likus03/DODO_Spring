package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;

import java.util.UUID;

public interface UserService {
    boolean create(UserWorkerRequestDTO request);
    boolean update(UUID id, UserRequestDTO userRequestDTO);
    boolean delete(UUID id);
}
