package by.it.academy.DODO;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.TentativeScheduleMapper;
import by.it.academy.DODO.services.tentativeSchedule.TentativeScheduleService;
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
        {
            tentativeScheduleService.createTentativeSchedule(UUID.randomUUID(), new TentativeScheduleDTO());
        });

        assertThrows(ClientInvalidDataException.class, () ->
        {
            tentativeScheduleService.createTentativeSchedule(UUID.randomUUID(), new TentativeScheduleDTO
                    (
                            LocalDate.parse("2024-05-07"),
                            LocalTime.parse("10:00"),
                            LocalTime.parse("23:00")
                    ));
        });

        assertThrows(DataIntegrityViolationException.class, () ->
        {
            tentativeScheduleService.createTentativeSchedule(UUID.fromString("1eb4b41f-1d03-4e4d-820a-7f51f62b19e4"),
                    new TentativeScheduleDTO());
        });
    }

    @Test
    @Transactional
    public void testSave() {
        assertThrows(DataIntegrityViolationException.class, () ->
        {
            tentativeScheduleService.saveTentativeSchedule(new TentativeSchedule());
        });
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
        {
            tentativeScheduleService.updateTentativeSchedule(UUID.randomUUID(),
                    tentativeScheduleMapper.createTentativeScheduleDTO(new TentativeSchedule
                            (
                                    LocalDate.parse("2024-05-07"),
                                    LocalTime.parse("10:00"),
                                    LocalTime.parse("23:00")
                            )
                    ));
        });
    }

    @Test
    @Transactional
    public void testGetWeekSchedule(){
        assertThrows(ClientInvalidDataException.class, () ->
        {
           tentativeScheduleService.getWeekTentativeSchedule(UUID.randomUUID(), LocalDate.now());
        });
    }

    @Test
    @Transactional
    public void testGetDaySchedule(){
        assertThrows(ClientInvalidDataException.class, () ->
        {
           tentativeScheduleService.getDayTentativeSchedule(LocalDate.parse("2100-01-01"));
        });
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
        {
            tentativeScheduleService.deleteTentativeSchedule(UUID.randomUUID());
        });
    }
}
