package by.it.academy.dodo;

import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.services.worker.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class WorkerServiceTest {
    private final WorkerService workerService;
    @Autowired
    public WorkerServiceTest(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Test
    @Transactional
    public void testGetWorkerWithNonExistingFirstname() {
        Assertions.assertThrows(ClientInvalidDataException.class, () ->
                workerService.getWorkersByFirstname(null)
        );
    }
    @Test
    @Transactional
    public void testGetWorkerWithNonExistingSurname() {
        Assertions.assertThrows(ClientInvalidDataException.class, () ->
                workerService.getWorkersBySurname(null)
        );
    }

    @Test
    @Transactional
    public void testGetWorkerWithNonExistingPhoneNumber() {
        Assertions.assertThrows(ClientInvalidDataException.class, () ->
                workerService.getWorkersByPhoneNumber(null)
        );
    }

    @Test
    @Transactional
    public void testGetWorkerWithNonExistingWorkerType() {
        Assertions.assertThrows(ClientInvalidDataException.class, () ->
                workerService.getWorkersByWorkerType(null)
        );
    }
}
