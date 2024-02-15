package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.User;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.UserMapper;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WorkerMapper workerMapper;
    private final UserMapper userMapper;
    /**
     * Creates a new user with associated worker data.
     *
     * @param userWorkerRequestDTO The DTO containing user and worker data.
     * @return {@code true} if the user is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the user or worker data is invalid.
     */
    @Transactional
    @Override
    public boolean createUser(UserWorkerRequestDTO userWorkerRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (userWorkerRequestDTO != null) {
            WorkerDTO workerDTO = userWorkerRequestDTO.getWorkerDTO();
            UserRequestDTO userRequestDTO = userWorkerRequestDTO.getUserRequestDTO();

            Worker worker = workerMapper.createWorker(workerDTO);
            User user = userMapper.createUser(userRequestDTO);

            if (worker != null & user != null) {
                user.setWorker(worker);
                return saveUser(user);
            }
            throw new ClientInvalidDataException("Unable to save");
        }
        throw new ClientInvalidDataException("Unable to create user");

    }
    /**
     * Saves the provided user to the repository.
     *
     * @param user The user to save.
     * @return {@code true} if the user is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the user data is invalid.
     */
    @Override
    @Transactional
    public boolean saveUser(User user) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (user != null) {
            try {
                userRepository.saveAndFlush(user);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save user");
            }
        }
        throw new ClientInvalidDataException("Unable to save user");
    }
    /**
     * Updates the user associated with the specified worker ID using the provided {@link UserRequestDTO}.
     *
     * @param idWorker          The ID of the associated worker.
     * @param userRequestDTO    The updated user data.
     * @return {@code true} if the user is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the user data is invalid.
     */
    @Transactional
    @Override
    public boolean updateUser(UUID idWorker, UserRequestDTO userRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (userRequestDTO != null) {
            User newUser = userMapper.createUser(userRequestDTO);
            Optional<User> optionalUser = userRepository.findByWorkerId(idWorker);
            if (optionalUser.isPresent()) {
                User oldUser = optionalUser.get();
                oldUser.setPassword(newUser.getPassword());

                return saveUser(oldUser);
            }
            throw new ClientInvalidDataException("User was not found");
        }
        throw new ClientInvalidDataException("Unable to update user");
    }
    /**
     * Deletes the user associated with the specified worker ID.
     *
     * @param idWorker The ID of the associated worker.
     * @return {@code true} if the user is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the user data is invalid.
     */
    @Transactional
    @Override
    public boolean deleteUser(UUID idWorker) throws ClientInvalidDataException {
        User user = userRepository.findByWorkerId(idWorker)
                .orElseThrow(() -> new ClientInvalidDataException("User was not found"));
        userRepository.delete(user);

        return true;
    }
}
