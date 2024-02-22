package by.it.academy.dodo.services.user;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.UserMapper;
import by.it.academy.dodo.mappers.WorkerMapper;
import by.it.academy.dodo.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
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
    public boolean createUser(UserWorkerRequestDto userWorkerRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        WorkerDto workerDTO = userWorkerRequestDTO.getWorker();
        UserRequestDto userRequestDTO = userWorkerRequestDTO.getUser();

        Worker worker = workerMapper.mapToWorker(workerDTO);
        User user = userMapper.mapToUser(userRequestDTO);

        if (worker != null && user != null) {
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
    public boolean updateUser(UUID workerId, UserRequestPutDto userRequestPutDto) {
        User newUser = userMapper.mapToUser(userRequestPutDto);
        return userRepository.updateUserPassword(workerId, newUser.getPassword());
    }

    @Transactional
    @Override
    public boolean deleteUser(UUID workerId) {
        return userRepository.deleteUser(workerId);
    }
}
