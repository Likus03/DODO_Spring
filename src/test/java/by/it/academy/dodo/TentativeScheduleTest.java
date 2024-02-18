package by.it.academy.dodo;

import by.it.academy.dodo.entities.TentativeSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.services.tentativeSchedule.TentativeScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TentativeScheduleTest {

    private final TentativeScheduleService tentativeScheduleService;

    @Autowired
    public TentativeScheduleTest(TentativeScheduleService tentativeScheduleService) {
        this.tentativeScheduleService = tentativeScheduleService;
    }

    @Test
    @Transactional
    public void testSaveTentativeScheduleInvalidData() {
        assertThrows(DataIntegrityViolationException.class, () ->
                tentativeScheduleService.saveTentativeSchedule(new TentativeSchedule()));
    }

    @Test
    @Transactional
    public void testGetWeekNonExistingTentativeScheduleByWorkerId() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.getWeekTentativeSchedule(UUID.randomUUID(), LocalDate.now()));
    }

    @Test
    @Transactional
    public void testGetDayNonExistingTentativeScheduleByWorkerId() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.getDayTentativeSchedule(LocalDate.parse("2100-01-01")));
    }

    @Test
    @Transactional
    public void testDeleteNonExistingTentativeScheduleById() {
        assertFalse(tentativeScheduleService.deleteTentativeSchedule(UUID.randomUUID()));
    }
}
