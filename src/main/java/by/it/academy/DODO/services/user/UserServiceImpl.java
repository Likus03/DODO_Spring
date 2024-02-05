package by.it.academy.DODO.services.user;

import by.it.academy.DODO.dto.UserDTO;
import by.it.academy.DODO.dto.UserWorkerDTO;
import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.User;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.mappers.UserMapper;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.user.UserRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import by.it.academy.DODO.services.worker.WorkerService;
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
    public boolean create(UserWorkerDTO request) {
        WorkerDTO workerDTO = request.getWorkerDTO();
        UserDTO userDTO = request.getUserDTO();

        Worker worker = workerMapper.createWorker(workerDTO);
        User user = userMapper.createUser(userDTO);

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
    public boolean update(UserDTO userDTO) {
        User user = userMapper.createUser(userDTO);
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
