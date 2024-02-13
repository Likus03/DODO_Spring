package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.services.tentativeSchedule.TentativeScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TentativeScheduleController {
    private final TentativeScheduleService tentativeScheduleService;

    @PostMapping("worker/{id}/tentativeSchedule")
    public boolean create(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO tentativeScheduleDTO) {
        return tentativeScheduleService.createTentativeSchedule(id, tentativeScheduleDTO);
    }

    @GetMapping("worker/{id}/tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getWeekTentativeSchedule(@PathVariable UUID id, @PathVariable LocalDate dateWork) {
        return tentativeScheduleService.getWeekTentativeSchedule(id, dateWork);
    }

    @GetMapping("tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getDayTentativeSchedule(@PathVariable LocalDate dateWork){
        return tentativeScheduleService.getDayTentativeSchedule(dateWork);
    }

    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO tentativeScheduleDTO){
        return tentativeScheduleService.updateTentativeSchedule(id, tentativeScheduleDTO);
    }

    @DeleteMapping("tentativeSchedule/{id}")
    public boolean delete(@PathVariable UUID id){
        return tentativeScheduleService.deleteTentativeSchedule(id);
    }
}
