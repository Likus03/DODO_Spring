package by.it.academy.dodo.services.user;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.entities.User;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.mappers.UserMapper;
import by.it.academy.dodo.mappers.WorkerMapper;
import by.it.academy.dodo.repositories.user.UserRepository;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    private final UserMapper userMapper;
    private final MongoTemplate mongoTemplate;

    @Transactional
    @Override
    public void createUser(UserWorkerRequestDto userWorkerRequestDTO) {
        WorkerDto workerDTO = userWorkerRequestDTO.getWorker();
        UserRequestDto userRequestDTO = userWorkerRequestDTO.getUser();

        Worker worker = workerMapper.mapToWorker(workerDTO);
        User user = userMapper.mapToUser(userRequestDTO);

        user.setWorker(workerRepository.save(worker));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean updateUser(ObjectId workerId, UserRequestPutDto userRequestPutDto) {
        Query query = new Query().addCriteria(where("worker").is(workerId));

        Update update = new Update().set("password", userRequestPutDto.getPassword());
        return mongoTemplate.updateFirst(query, update, User.class).getMatchedCount() == 1;
    }

    @Transactional
    @Override
    public void deleteUser(ObjectId workerId) {
        Query query = new Query().addCriteria(where("worker").is(workerId));
        mongoTemplate.findAndRemove(query, User.class);
        workerRepository.deleteById(workerId);
    }
}