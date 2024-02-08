package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.response.tentativeSchedule.TentativeScheduleResponseDTO;
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
    public boolean create(@PathVariable UUID id, @RequestBody TentativeScheduleResponseDTO request) {
        return tentativeScheduleService.create(id, request);
    }

    @GetMapping("worker/{id}/tentativeSchedule/{dateWork}")
    public List<TentativeScheduleResponseDTO> getWeekScheduleByIdWorker(@PathVariable UUID id, @PathVariable LocalDate dateWork) {
        return tentativeScheduleService.readWeekScheduleByIdWorker(id, dateWork);
    }

    @GetMapping("tentativeSchedule/{dateWork}")
    public List<TentativeScheduleResponseDTO> getDaySchedule(@PathVariable LocalDate dateWork){
        return tentativeScheduleService.readDaySchedule(dateWork);
    }

    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable UUID id, @RequestBody TentativeScheduleResponseDTO request){
        return tentativeScheduleService.update(id, request);
    }

    @DeleteMapping("tentativeSchedule/{id}")
    public boolean delete(@PathVariable UUID id){
        return tentativeScheduleService.delete(id);
    }
}
