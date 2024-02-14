package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.services.tentativeSchedule.TentativeScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public boolean create(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO tentativeScheduleDTO) {
        return tentativeScheduleService.createTentativeSchedule(id, tentativeScheduleDTO);
    }

    /**
     * Retrieve the tentative schedule of a worker for a specific week.
     * @param id Worker's ID.
     * @param dateWork The date of the week for which the tentative schedule is being requested.
     * @return A list of {@link TentativeScheduleDTO} objects representing the day's tentative schedule.
     */
    @GetMapping("worker/{id}/tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getWeekTentativeSchedule(@PathVariable UUID id, @PathVariable LocalDate dateWork) {
        return tentativeScheduleService.getWeekTentativeSchedule(id, dateWork);
    }

    /**
     * Retrieve the tentative schedule of a worker for a specific day.
     *
     * @param dateWork The date for which the tentative schedule is requested.
     * @return A list of {@link TentativeScheduleDTO} objects representing the day's tentative schedule.
     */
    @GetMapping("tentativeSchedule/{dateWork}")
    public List<TentativeScheduleDTO> getDayTentativeSchedule(@PathVariable LocalDate dateWork){
        return tentativeScheduleService.getDayTentativeSchedule(dateWork);
    }

    /**
     * Update tentative schedule by ID.
     *
     * @param id                  Tentative schedule's ID.
     * @param tentativeScheduleDTO The DTO containing updated tentative schedule information.
     * @return `true` if the tentative schedule is successfully created.
     * In case of an error, returns error message.
     */
    @PutMapping("tentativeSchedule/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody TentativeScheduleDTO tentativeScheduleDTO){
        return tentativeScheduleService.updateTentativeSchedule(id, tentativeScheduleDTO);
    }

    /**
     * Delete a tentative schedule by ID.
     *
     * @param id Tentative schedule's ID.
     * @return `true` if the tentative schedule is successfully created. In case of an error, returns error message.
     */
    @DeleteMapping("tentativeSchedule/{id}")
    public boolean delete(@PathVariable UUID id){
        return tentativeScheduleService.deleteTentativeSchedule(id);
    }
}
