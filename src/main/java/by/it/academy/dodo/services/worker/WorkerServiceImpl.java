package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.WorkerMapper;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

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
        List<Worker> workers = workerRepository
                .findByWorkerType(workerType);

        return getWorkerDto(workers);
    }

    @Transactional
    @Override
    public boolean updateWorker(UUID id, WorkerDto workerDTO) {
        Worker newWorker = workerMapper.mapToWorker(workerDTO);
        return workerRepository.updateWorker(id, newWorker);
    }

    private List<WorkerDto> getWorkerDto(List<Worker> workers) throws ClientInvalidDataException {
        if (workers.isEmpty()) {
            throw new ClientInvalidDataException("Worker does not exist");
        }

        return workerMapper.mapToWorkerDtoList(workers);
    }
}
