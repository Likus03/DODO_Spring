package by.it.academy.DODO;

import by.it.academy.DODO.dto.WorkerDTO;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.WorkerMapper;
import by.it.academy.DODO.services.worker.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WorkerServiceTests {
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    @Autowired
    public WorkerServiceTests(WorkerService workerService, WorkerMapper workerMapper) {
        this.workerService = workerService;
        this.workerMapper = workerMapper;
    }

    @Test
    @Transactional
    public void testGetByParameter() {
        Assertions.assertThrows(ClientInvalidDataException.class, () ->
                workerService.getWorkersByParameter(null)
        );
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
                workerService.updateWorker(UUID.randomUUID(),
                        workerMapper.createWorkerDTO(new Worker(
                                "Alex",
                                "Pick",
                                "+375442583415",
                                WorkerType.KITCHEN_WORKER)
                        )));

        assertThrows(DataIntegrityViolationException.class, () ->
                workerService.updateWorker(UUID.fromString("7d614120-0ea9-4935-bd5f-d47619d6248a"), new WorkerDTO()));
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
                workerService.saveWorker(new Worker()));
    }
}
