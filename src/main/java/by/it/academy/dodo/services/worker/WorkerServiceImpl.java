package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.WorkerMapper;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;
    private final MongoTemplate mongoTemplate;

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDto> getWorkersByFirstname(String firstname) throws ClientInvalidDataException {
        List<Worker> workers = workerRepository
                .findByFirstnameContainingIgnoreCase(firstname);

        return getWorkerDto(workers);
    }

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDto> getWorkersByPhoneNumber(String phoneNumber) throws ClientInvalidDataException {
        List<Worker> workers = workerRepository
                .findByPhoneNumberContaining(phoneNumber);

        return getWorkerDto(workers);
    }

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDto> getWorkersBySurname(String surname) throws ClientInvalidDataException {
        List<Worker> workers = workerRepository
                .findBySurnameContainingIgnoreCase(surname);

        return getWorkerDto(workers);
    }

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDto> getWorkersByWorkerType(String workerType) throws ClientInvalidDataException {
        Pattern pattern = compile(workerType, CASE_INSENSITIVE);
        Query query = new Query().addCriteria(where("workerType").regex(pattern));

        return getWorkerDto(mongoTemplate.find(query, Worker.class));
    }

    @Transactional
    @Override
    public void updateWorker(ObjectId id, WorkerDto workerDTO) {
        Worker worker = workerMapper.mapToWorker(workerDTO);
        worker.setId(id);
        workerRepository.save(worker);
    }

    private List<WorkerDto> getWorkerDto(List<Worker> workers) throws ClientInvalidDataException {
        if (workers.isEmpty()) {
            throw new ClientInvalidDataException("Worker does not exist");
        }

        return workerMapper.mapToWorkerDtoList(workers);
    }
}
