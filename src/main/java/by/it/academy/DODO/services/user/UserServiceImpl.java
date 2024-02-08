package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.entities.User;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.mappers.UserMapper;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean create(UserWorkerRequestDTO request) {
        WorkerRequestDTO workerRequestDTO = request.getWorkerRequestDTO();
        UserRequestDTO userRequestDTO = request.getUserRequestDTO();

        Worker worker = workerMapper.createWorker(workerRequestDTO);
        User user = userMapper.createUser(userRequestDTO);

        user.setWorker(worker);
        try {
            userRepository.save(user);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean update(UserRequestDTO userRequestDTO) {
        User user = userMapper.createUser(userRequestDTO);
        try {
            userRepository.save(user);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean delete(UUID id) {
        try {
            userRepository.deleteById(id);
        } catch (IllegalArgumentException ex) {
            log.error("reason: ", ex.getCause());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public User getLoggedUser(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
