package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDTO> readAll() {
        return workerRepository.findAll().stream()
                .map(workerMapper::createWorkerDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<WorkerDTO> readBySearch(String parameter) {
        return workerRepository.findByParameter(parameter)
                .map(workers -> workers.stream()
                        .map(workerMapper::createWorkerDTO)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Transactional
    @Override
    public boolean update(UUID id, WorkerDTO request) {
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

//    @Transactional
//    @Override
//    public boolean delete(UUID id) {
//        Optional<Worker> optionalWorker = workerRepository.findById(id);
//        if (optionalWorker.isPresent()) {
//            Worker worker = optionalWorker.get();
//            workerRepository.delete(worker);
//            return true;
//        }
//        return false;
//    }

    @Transactional(readOnly = true)
    @Override
    public Worker findById(UUID id) {
        return workerRepository.findById(id).orElse(null);
    }
}
