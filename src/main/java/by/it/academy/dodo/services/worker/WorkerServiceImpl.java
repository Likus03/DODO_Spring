package by.it.academy.dodo.services.worker;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.WorkerMapper;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
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
    /**
     * Retrieves a list of workers based on the provided parameter.
     *
     * @param parameter The parameter to search for in worker details.
<<<<<<< HEAD
     * @return A list of {@link WorkerDto}.
=======
     * @return A list of {@link WorkerRequestDTO}.
>>>>>>> dd07fcaaba3d9dbab4173cab642880a17f9b85ab
     * @throws ClientInvalidDataException If the worker data is invalid or not found.
     */
    @Transactional(readOnly = true)
    @Override
    public List<WorkerDto> getWorkersByParameter(String parameter) throws ClientInvalidDataException {
        List<Worker> workers = workerRepository
                .findByParameter(parameter).orElse(Collections.emptyList());

        if (workers.isEmpty()) {
            throw new ClientInvalidDataException("Worker does not exist");
        }

        return workerMapper.createWorkerDTOList(workers);
    }
    /**
     * Updates the worker with the specified ID using the provided {@link WorkerDto}.
     *
     * @param id               The ID of the worker to update.
     * @param workerDTO The updated worker data.
     * @return {@code true} if the worker is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the worker data is invalid or not found.
     */
    @Transactional
    @Override
    public boolean updateWorker(UUID id, WorkerDto workerDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (workerDTO != null) {
            Worker newWorker = workerMapper.createWorker(workerDTO);
            Optional<Worker> optionalWorker = workerRepository.findById(id);
            if (optionalWorker.isPresent()) {
                Worker oldWorker = optionalWorker.get();
                setUpdatingWorker(newWorker, oldWorker);

                return saveWorker(oldWorker);
            }
            throw new ClientInvalidDataException("Worker was not found");
        }
        throw new ClientInvalidDataException("Unable to update worker");
    }
    /**
     * Saves the provided worker to the repository.
     *
     * @param worker The worker to save.
     * @return {@code true} if the worker is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the worker data is invalid.
     */
    @Override
    @Transactional
    public boolean saveWorker(Worker worker) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (worker != null) {
            try {
                workerRepository.saveAndFlush(worker);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save worker");
            }
        }
        throw new ClientInvalidDataException("Unable to save worker");
    }

    /**
     * Sets up the updating of the worker with new worker data.
     * @param newWorker The new worker data.
     * @param oldWorker The existing worker data.
     */
    private void setUpdatingWorker(Worker newWorker, Worker oldWorker) {
        oldWorker.setFirstname(newWorker.getFirstname());
        oldWorker.setSurname(newWorker.getSurname());
        oldWorker.setPhoneNumber(newWorker.getPhoneNumber());
        oldWorker.setWorkerType(newWorker.getWorkerType());
    }
}
