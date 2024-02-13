package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<WorkerRequestDTO> getWorkersByParameter(String parameter) throws ClientInvalidDataException {
        List<Worker> workers = workerRepository
                .findByParameter(parameter).orElse(Collections.emptyList());

        if (workers.isEmpty()) {
            throw new ClientInvalidDataException("Worker does not exist");
        }

        return workers.stream()
                .map(workerMapper::createWorkerDTO)
                .toList();
    }

    @Transactional
    @Override
    public boolean updateWorker(UUID id, WorkerRequestDTO request) throws DataIntegrityViolationException, ClientInvalidDataException {
        Worker newWorker = workerMapper.createWorker(request);
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (optionalWorker.isPresent()) {
            Worker oldWorker = optionalWorker.get();
            setUpdatingWorker(newWorker, oldWorker);

            return saveWorker(oldWorker);
        }
        throw new ClientInvalidDataException("Worker was not found");
    }

    @Override
    @Transactional
    public boolean saveWorker(Worker worker) throws DataIntegrityViolationException {
        try {
            workerRepository.saveAndFlush(worker);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save worker");
        }
    }

    private void setUpdatingWorker(Worker newWorker, Worker oldWorker) {
        oldWorker.setFirstname(newWorker.getFirstname());
        oldWorker.setSurname(newWorker.getSurname());
        oldWorker.setPhoneNumber(newWorker.getPhoneNumber());
        oldWorker.setWorkerType(newWorker.getWorkerType());
    }
}
