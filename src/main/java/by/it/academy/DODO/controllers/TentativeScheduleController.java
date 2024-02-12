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
    public boolean create(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO request) {
        return tentativeScheduleService.create(id, request);
    }

    @GetMapping("worker/{id}/tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getWeekScheduleByIdWorker(@PathVariable UUID id, @PathVariable LocalDate dateWork) {
        return tentativeScheduleService.getWeekScheduleByIdWorker(id, dateWork);
    }

    @GetMapping("tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getDaySchedule(@PathVariable LocalDate dateWork){
        return tentativeScheduleService.getDaySchedule(dateWork);
    }

    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO request){
        return tentativeScheduleService.update(id, request);
    }

    @DeleteMapping("tentativeSchedule/{id}")
    public boolean delete(@PathVariable UUID id){
        return tentativeScheduleService.delete(id);
    }
}
