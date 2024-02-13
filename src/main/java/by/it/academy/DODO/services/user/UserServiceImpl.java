package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
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

    @Transactional
    @Override
    public boolean createUser(UserWorkerRequestDTO request) throws DataIntegrityViolationException {
        WorkerRequestDTO workerRequestDTO = request.getWorkerRequestDTO();
        UserRequestDTO userRequestDTO = request.getUserRequestDTO();

        Worker worker = workerMapper.createWorker(workerRequestDTO);
        User user = userMapper.createUser(userRequestDTO);

        if(worker != null & user != null) {
            user.setWorker(worker);
            return saveUser(user);
        }
        throw new ClientInvalidDataException("Unable to save");
    }

    @Override
    @Transactional
    public boolean saveUser(User user) throws DataIntegrityViolationException {
        try {
            userRepository.saveAndFlush(user);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save user");
        }
    }

    @Transactional
    @Override
    public boolean updateUser(UUID idWorker, UserRequestDTO userRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        User newUser = userMapper.createUser(userRequestDTO);
        Optional<User> optionalUser = userRepository.findByWorkerId(idWorker);
        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.setPassword(newUser.getPassword());

            return saveUser(oldUser);
        }
        throw new ClientInvalidDataException("User was not found");
    }

    @Transactional
    @Override
    public boolean deleteUser(UUID idWorker) throws ClientInvalidDataException {
        User user = userRepository.findByWorkerId(idWorker)
                .orElseThrow(() -> new ClientInvalidDataException("User was not found"));
        userRepository.delete(user);

        return true;
    }
}
