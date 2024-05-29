package by.it.academy.dodo;

import by.it.academy.dodo.entities.WorkSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.services.workSchedule.WorkScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WorkScheduleTest {
    private final WorkScheduleService workScheduleService;

    @Autowired
    public WorkScheduleTest(WorkScheduleService workScheduleService) {
        this.workScheduleService = workScheduleService;
    }

    @Test
    @Transactional
    public void testSaveWorkScheduleInvalidData() {
        assertThrows(DataIntegrityViolationException.class, () ->
                workScheduleService.saveWorkSchedule(new WorkSchedule()));
    }

    @Test
    @Transactional
    public void testGetWeekNonExistingWorkScheduleByWorkerId() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.getWeekWorkSchedule(null, null));
    }

    @Test
    @Transactional
    public void testGetDayNonExistingWorkScheduleByWorkerId() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.getDayWorkSchedule(null));
    }

    @Test
    @Transactional
    public void testDeleteNonExistingWorkScheduleById() {
//        assertFalse(workScheduleService.deleteWorkSchedule(UUID.randomUUID()));
    }
}
