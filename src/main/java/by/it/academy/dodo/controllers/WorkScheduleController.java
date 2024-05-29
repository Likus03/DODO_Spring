package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.services.workSchedule.WorkScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

/**
 * The `WorkSchedule` class provides RESTful endpoints for managing work-schedule-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/worker/{id}/workSchedule - Create a new work schedule by worker ID.</li>
 *   <li>GET /api/v1/workSchedule/{startWork}/{endWork} - Retrieve the work schedule of a worker for a specific week.</li>
 *   <li>GET /api/v1/workSchedule/{dateWork}- Retrieve the work schedule of a worker for a specific day.</li>
 *   <li>DELETE /api/v1/workSchedule/{id} - Delete work schedule by ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link WorkScheduleService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link WorkScheduleService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WorkScheduleController {
    private final WorkScheduleService workScheduleService;

    /**
     * Create a new work schedule by worker ID.
     * @param id Worker's ID.
     * @param workScheduleRequestDTO The work schedule data to be created.
     * @return `true` if the work schedule is successfully created.
     * In case of an error, returns error message.
     */
    @PostMapping("worker/{id}/workSchedule")
    public boolean createWorkSchedule(@PathVariable ObjectId id, @Valid @RequestBody WorkScheduleRequestDto workScheduleRequestDTO){
        return workScheduleService.createWorkSchedule(id, workScheduleRequestDTO);
    }

    /**
     * Retrieve the work schedule of a worker for a specific day.
     *
     * @param workDate The date for which the work schedule is requested.
     * @return A list of {@link WorkScheduleResponseDto} objects representing the day's work schedule.
     */
    @GetMapping("workSchedule/{workDate}")
    public List<WorkScheduleResponseDto> getDayWorkSchedule(@PathVariable LocalDate workDate){
        return workScheduleService.getDayWorkSchedule(workDate);
    }

    /**
     * Retrieve the work schedule of a worker for a specific week.
     * @param startWork  Start date of the week.
     * @param endWork End date of the week.
     * @return List of {@link WorkScheduleResponseDto} responses for the specified week
     */
    @GetMapping("workSchedule/{startWork}/{endWork}")
    public List<WorkScheduleResponseDto> getWeekWorkSchedule(@PathVariable LocalDate startWork, @PathVariable LocalDate endWork){
        return workScheduleService.getWeekWorkSchedule(startWork, endWork);
    }

    /**
     * Delete work schedule by ID.
     * @param id Work schedule's ID.
     * @return `true` if the work schedule is successfully created, otherwise `false`.
     */
    @DeleteMapping("workSchedule/{id}")
    public ResponseEntity<String> deleteWorkSchedule(@PathVariable ObjectId id){
        workScheduleService.deleteWorkSchedule(id);
        return new ResponseEntity<>("Schedule deleted successfully", OK);
    }
}
