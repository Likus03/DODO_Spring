package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.services.tentativeSchedule.TentativeScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * The `TentativeSchedule` class provides RESTful endpoints for managing tentative-schedule-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/worker/{id}/tentativeSchedule - Create a new tentative schedule by worker ID.</li>
 *   <li>GET /api/v1/worker/{id}/tentativeSchedule/{dateWork} - Retrieve the tentative schedule of a worker for a specific week.</li>
 *   <li>GET /api/v1/tentativeSchedule/{dateWork} - Retrieve the tentative schedule of a worker for a specific day.</li>
 *   <li>PUT /api/v1/tentativeSchedule/{id} - Update tentative schedule by ID.</li>
 *   <li>DELETE /api/v1/tentativeSchedule/{id} - Delete a tentative schedule by ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link TentativeScheduleService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link TentativeScheduleService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TentativeScheduleController {
    private final TentativeScheduleService tentativeScheduleService;

    /**
     * Create a new tentative schedule by worker ID.
     * @param id Worker's ID.
     * @param tentativeScheduleDTO The tentative schedule data to be created.
     * @return `true` if the tentative schedule is successfully created.
     * In case of an error, returns error message.
     */
    @PostMapping("worker/{id}/tentativeSchedule")
    public boolean createTentativeSchedule(@PathVariable ObjectId id, @Valid @RequestBody TentativeScheduleDto tentativeScheduleDTO) {
        return tentativeScheduleService.createTentativeSchedule(id, tentativeScheduleDTO);
    }

    /**
     * Retrieve the tentative schedule of a worker for a specific week.
     * @param id Worker's ID.
     * @param workDate The date of the week for which the tentative schedule is being requested.
     * @return A list of {@link TentativeScheduleDto} objects representing the day's tentative schedule.
     */
    @GetMapping("worker/{id}/tentativeSchedule/{workDate}")
    public List<TentativeScheduleDto> getWeekTentativeSchedule(@PathVariable ObjectId id, @PathVariable LocalDate workDate) {
        return tentativeScheduleService.getWeekTentativeSchedule(id, workDate);
    }

    /**
     * Retrieve the tentative schedule of a worker for a specific day.
     *
     * @param workDate The date for which the tentative schedule is requested.
     * @return A list of {@link TentativeScheduleDto} objects representing the day's tentative schedule.
     */
    @GetMapping("tentativeSchedule/{workDate}")
    public List<TentativeScheduleDto> getDayTentativeSchedule(@PathVariable LocalDate workDate){
        return tentativeScheduleService.getDayTentativeSchedule(workDate);
    }

    /**
     * Update tentative schedule by ID.
     *
     * @param id                  Tentative schedule's ID.
     * @param tentativeScheduleDTO The DTO containing updated tentative schedule information.
     * @return `true` if the tentative schedule is successfully created, otherwise `false`.
     */
    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable ObjectId id, @Valid @RequestBody TentativeScheduleDto tentativeScheduleDTO){
        return tentativeScheduleService.updateTentativeSchedule(id, tentativeScheduleDTO);
    }

    /**
     * Delete a tentative schedule by ID.
     *
     * @param id Tentative schedule's ID.
     * @return `true` if the tentative schedule is successfully created, otherwise `false`.
     */
    @DeleteMapping("tentativeSchedule/{id}")
    public boolean deleteTentativeSchedule(@PathVariable ObjectId id){
        return tentativeScheduleService.deleteTentativeSchedule(id);
    }
}
