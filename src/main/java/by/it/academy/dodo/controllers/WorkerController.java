package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.services.worker.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The `WorkerController` class provides RESTful endpoints for managing worker-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>GET /api/v1/workers?firstname - Get workers by firstname.</li>
 *   <li>GET /api/v1/workers?surname - Get workers by surname.</li>
 *   <li>GET /api/v1/workers?phoneNumber - Get workers by phoneNumber.</li>
 *   <li>GET /api/v1/workers?workerType - Get workers by workerType.</li>
 *   <li>PUT /api/v1/worker/{id} - Update worker by ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link WorkerService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link WorkerService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WorkerController {
    private final WorkerService workerService;

    /**
     * Get workers by firstname.
     *
     * @param firstname The firstname for filtering workers items.
     * @return The list of {@link WorkerDto} containing the worker's information.
     */
    @GetMapping(value = "workers", params = "firstname")
    public List<WorkerDto> getWorkersByFirstname(@RequestParam String firstname) {
        return workerService.getWorkersByFirstname(firstname);
    }

    /**
     * Get workers by surname.
     *
     * @param surname The surname for filtering workers items.
     * @return The list of {@link WorkerDto} containing the worker's information.
     */
    @GetMapping(value = "workers", params = "surname")
    public List<WorkerDto> getWorkersBySurname(@RequestParam String surname) {
        return workerService.getWorkersBySurname(surname);
    }

    /**
     * Get workers by phone number.
     *
     * @param phoneNumber The phoneNumber for filtering workers items.
     * @return The list of {@link WorkerDto} containing the worker's information.
     */
    @GetMapping(value = "workers", params = "phoneNumber")
    public List<WorkerDto> getWorkersByPhoneNumber(@RequestParam String phoneNumber) {
        return workerService.getWorkersByPhoneNumber(phoneNumber);
    }

    /**
     * Get workers by worker type.
     *
     * @param workerType The worker type for filtering workers items.
     * @return The list of {@link WorkerDto} containing the worker's information.
     */
    @GetMapping(value = "workers", params = "workerType")
    public List<WorkerDto> getWorkersByWorkerType(@RequestParam String workerType) {
        return workerService.getWorkersByWorkerType(workerType);
    }

    /**
     * Update worker by ID.
     *
     * @param id        Worker's ID.
     * @param workerDTO The updated worker data.
     * @return `true` if the menu is successfully updated, otherwise `false`.
     */
    @PutMapping("worker/{id}")
    public ResponseEntity<String> updateWorker(@PathVariable ObjectId id, @Valid @RequestBody WorkerDto workerDTO) {
        workerService.updateWorker(id, workerDTO);
        return new ResponseEntity<>("Worker updated successfully.", HttpStatus.OK);
    }
}
