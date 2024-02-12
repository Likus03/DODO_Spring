package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.services.workSchedule.WorkScheduleService;
import jakarta.validation.Valid;
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

    @PostMapping("worker/{id}/workSchedule")
    public boolean create(@PathVariable UUID id, @Valid @RequestBody WorkScheduleRequestDTO workScheduleRequestDTO){
        return workScheduleService.createWorkSchedule(id, workScheduleRequestDTO);
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
