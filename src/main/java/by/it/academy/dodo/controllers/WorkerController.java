package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.services.worker.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The `WorkerController` class provides RESTful endpoints for managing worker-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>GET /api/v1/workers/{parameter} - Get workers by parameter.</li>
 *   <li>PATCH /api/v1/worker/{id} - Update worker by ID.</li>
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
     * Get workers by parameter.
     *
     * @param parameter The parameter for filtering workers items.
<<<<<<< HEAD
     * @return The list of {@link WorkerDto} containing the worker's information.
=======
     * @return The list of {@link WorkerRequestDTO} containing the worker's information.
>>>>>>> dd07fcaaba3d9dbab4173cab642880a17f9b85ab
     */
    @GetMapping("workers/{parameter}")
    public List<WorkerDto> getByParameter(@PathVariable String parameter) {
        return workerService.getWorkersByParameter(parameter);
    }

    /**
     * Update worker by ID.
     *
     * @param id               Worker's ID.
<<<<<<< HEAD
     * @param workerDTO The updated worker data.
=======
     * @param workerRequestDTO The updated worker data.
>>>>>>> dd07fcaaba3d9dbab4173cab642880a17f9b85ab
     * @return `true` if the menu is successfully updated.
     * In case of an error, returns error message.
     */
    @PatchMapping("worker/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody WorkerDto workerDTO) {
        return workerService.updateWorker(id, workerDTO);
    }
}
