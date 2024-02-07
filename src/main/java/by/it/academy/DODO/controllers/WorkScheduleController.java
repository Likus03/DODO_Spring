package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.WorkScheduleResponseDTO;
import by.it.academy.DODO.services.workSchedule.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WorkScheduleController {
    private final WorkScheduleService workScheduleService;

    @PostMapping("workSchedule")
    public boolean create(@RequestBody WorkScheduleRequestDTO workScheduleRequestDTO){
        return workScheduleService.createWorkSchedule(workScheduleRequestDTO);
    }

    @GetMapping("workSchedule/{dateWork}")
    public List<WorkScheduleResponseDTO> getDayWorkSchedule(@PathVariable LocalDate dateWork){
        return workScheduleService.getDayWorkSchedule(dateWork);
    }

    @GetMapping("workSchedule/{startWork}/{endWork}")
    public List<WorkScheduleResponseDTO> getWeekWorkSchedule(@PathVariable LocalDate startWork, @PathVariable LocalDate endWork){
        return workScheduleService.getWeekWorkSchedule(startWork, endWork);
    }

    @DeleteMapping("workSchedule/{id}")
    public boolean deleteWorkSchedule(@PathVariable UUID id){
        return workScheduleService.deleteWorkSchedule(id);
    }
}
