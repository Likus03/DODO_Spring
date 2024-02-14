package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.services.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
/**
 * The `UserController` class provides RESTful endpoints for managing user-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/user - Create a new user.</li>
 *   <li>DELETE /api/v1/user/{idWorker} - Delete user by Worker's ID.</li>
 *   <li>PATCH /api/v1/user/{idWorker} - Update user by Worker's ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link UserService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link UserService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    /**
     * Create a new user.
     *
     * @param userWorkerRequestDTO DTO containing user and worker information.
     * @return `true` if the user creation is successful. In case of an error, returns error message.
     */
    @PostMapping("user")
    public boolean create(@Valid @RequestBody UserWorkerRequestDTO userWorkerRequestDTO) {
        return userService.createUser(userWorkerRequestDTO);
    }

    /**
     * Delete user by Worker's ID.
     *
     * @param idWorker Worker's ID.
     * @return `true` if the user deletion is successful. In case of an error, returns error message.
     */
    @DeleteMapping("user/{idWorker}")
    public boolean delete(@PathVariable UUID idWorker){
        return userService.deleteUser(idWorker);
    }

    /**
     *
     * @param idWorker Worker's ID.
     * @param userRequestDTO DTO containing updated user information.
     * @return `true` if the user update is successful. In case of an error, returns error message.
     */
    @PatchMapping("user/{idWorker}")
    public boolean update(@PathVariable UUID idWorker, @Valid @RequestBody UserRequestDTO userRequestDTO){
        return userService.updateUser(idWorker, userRequestDTO);
    }
}
