package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.EmptyObjectException;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<WorkerRequestDTO> readBySearch(String parameter) throws EmptyObjectException {
        List<Worker> workers = workerRepository
                .findByParameter(parameter).orElseThrow(() -> new NoSuchElementException(parameter));

        if (workers.isEmpty()) {
            throw new EmptyObjectException(parameter);
        }

        return workers.stream()
                .map(workerMapper::createWorkerDTO)
                .toList();
    }

    @Transactional
    @Override
    public boolean update(UUID id, WorkerRequestDTO request) {
        Worker newWorker = workerMapper.createWorker(request);
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (optionalWorker.isPresent()) {
            Worker oldWorker = optionalWorker.get();
            setUpdatingWorker(newWorker, oldWorker);
            workerRepository.save(oldWorker);
            return true;
        }
        return false;
    }

    private void setUpdatingWorker(Worker newWorker, Worker oldWorker) {
        oldWorker.setFirstname(newWorker.getFirstname());
        oldWorker.setSurname(newWorker.getSurname());
        oldWorker.setPhoneNumber(newWorker.getPhoneNumber());
        oldWorker.setWorkerType(newWorker.getWorkerType());
    }

    @Transactional(readOnly = true)
    @Override
    public Worker findById(UUID id) throws EmptyObjectException {
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            throw new EmptyObjectException(id.toString());
        }
        return worker;
    }
}
