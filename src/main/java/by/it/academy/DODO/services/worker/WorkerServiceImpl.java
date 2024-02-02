package by.it.academy.DODO.services.worker;

import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Worker> readAll() {
        return workerRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public List<Worker> readBySearch(String parameter) {
        return workerRepository.findByParameter(parameter).orElse(null);
    }
    @Transactional
    @Override
    public boolean update(Worker newWorker) {
        Optional<Worker> optionalWorker = workerRepository.findById(newWorker.getId());
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
    @Transactional
    @Override
    public boolean delete(UUID id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if(optionalWorker.isPresent()){
            Worker worker = optionalWorker.get();
            workerRepository.delete(worker);
            return true;
        }
        return false;
    }
    @Transactional(readOnly = true)
    @Override
    public Worker findById(UUID id) {
        return workerRepository.findById(id).orElse(null);
    }
}
