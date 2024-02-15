package by.it.academy.dodo;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.entities.WorkSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.services.workSchedule.WorkScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WorkScheduleTests {
    private final WorkScheduleService workScheduleService;

    @Autowired
    public WorkScheduleTests(WorkScheduleService workScheduleService) {
        this.workScheduleService = workScheduleService;
    }

    @Test
    @Transactional
    public void testCreate() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.createWorkSchedule(UUID.randomUUID(), new WorkScheduleRequestDto()));

        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.createWorkSchedule(UUID.randomUUID(), new WorkScheduleRequestDto
                        (
                                LocalDate.parse("2024-05-07"),
                                LocalTime.parse("10:00"),
                                LocalTime.parse("23:00")
                        )));

        assertThrows(DataIntegrityViolationException.class, () ->
                workScheduleService.createWorkSchedule(UUID.fromString("1eb4b41f-1d03-4e4d-820a-7f51f62b19e4"),
                        new WorkScheduleRequestDto()));
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
                workScheduleService.saveWorkSchedule(new WorkSchedule()));
    }

    @Test
    @Transactional
    public void testGetWeekSchedule() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.getWeekWorkSchedule(null, null));
    }

    @Test
    @Transactional
    public void testGetDaySchedule() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.getDayWorkSchedule(null));
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
                workScheduleService.deleteWorkSchedule(UUID.randomUUID()));
    }
}
