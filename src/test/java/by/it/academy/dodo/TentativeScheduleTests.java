package by.it.academy.dodo;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.entities.TentativeSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.TentativeScheduleMapper;
import by.it.academy.dodo.services.tentativeSchedule.TentativeScheduleService;
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
public class TentativeScheduleTests {

    private final TentativeScheduleService tentativeScheduleService;
    private final TentativeScheduleMapper tentativeScheduleMapper;

    @Autowired
    public TentativeScheduleTests(TentativeScheduleService tentativeScheduleService, TentativeScheduleMapper tentativeScheduleMapper) {
        this.tentativeScheduleService = tentativeScheduleService;
        this.tentativeScheduleMapper = tentativeScheduleMapper;
    }

    @Test
    @Transactional
    public void testCreate() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.createTentativeSchedule(UUID.randomUUID(), new TentativeScheduleDto()));

        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.createTentativeSchedule(UUID.randomUUID(), new TentativeScheduleDto
                        (
                                LocalDate.parse("2024-05-07"),
                                LocalTime.parse("10:00"),
                                LocalTime.parse("23:00")
                        )));

        assertThrows(DataIntegrityViolationException.class, () ->
                tentativeScheduleService.createTentativeSchedule(UUID.fromString("1eb4b41f-1d03-4e4d-820a-7f51f62b19e4"),
                        new TentativeScheduleDto()));
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
                tentativeScheduleService.saveTentativeSchedule(new TentativeSchedule()));
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.updateTentativeSchedule(UUID.randomUUID(),
                        tentativeScheduleMapper.createTentativeScheduleDTO(new TentativeSchedule
                                (
                                        LocalDate.parse("2024-05-07"),
                                        LocalTime.parse("10:00"),
                                        LocalTime.parse("23:00")
                                )
                        )));
    }

    @Test
    @Transactional
    public void testGetWeekSchedule() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.getWeekTentativeSchedule(UUID.randomUUID(), LocalDate.now()));
    }

    @Test
    @Transactional
    public void testGetDaySchedule() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.getDayTentativeSchedule(LocalDate.parse("2100-01-01")));
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
                tentativeScheduleService.deleteTentativeSchedule(UUID.randomUUID()));
    }
}
