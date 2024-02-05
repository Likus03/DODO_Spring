package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import by.it.academy.DODO.services.tentativeSchedule.TentativeScheduleService;
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
    public boolean create(@PathVariable UUID id, @RequestBody TentativeScheduleDTO request) {
        return tentativeScheduleService.create(id, request);
    }

    @GetMapping("worker/{id}/tentativeSchedule")
    public List<TentativeSchedule> read(@PathVariable UUID id, @RequestBody LocalDate dateWork) {
        return tentativeScheduleService.read(id, dateWork);
    }

    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable UUID id, @RequestBody TentativeScheduleDTO request){
        return tentativeScheduleService.update(id, request);
    }

    @DeleteMapping("tentativeSchedule/{id}")
    public boolean delete(@PathVariable UUID id){
        return tentativeScheduleService.delete(id);
    }
}
