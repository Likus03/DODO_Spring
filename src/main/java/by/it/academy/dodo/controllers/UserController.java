package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.request.UserWorkerRequestDto;
import by.it.academy.dodo.dto.request.user.UserRequestPutDto;
import by.it.academy.dodo.services.user.UserService;
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
 *   <li>DELETE /api/v1/user/{workerId} - Delete user by Worker's ID.</li>
 *   <li>PUT /api/v1/user/{workerId} - Update user by Worker's ID.</li>
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
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    /**
     * Create a new user.
     *
     * @param userWorkerRequestDTO DTO containing user and worker information.
     * @return `true` if the user creation is successful. In case of an error, returns error message.
     */
    @PostMapping
    public boolean createUser(@Valid @RequestBody UserWorkerRequestDto userWorkerRequestDTO) {
        return userService.createUser(userWorkerRequestDTO);
    }

    /**
     * Delete user by Worker's ID.
     *
     * @param workerId Worker's ID.
     * @return `true` if the user deletion is successful, otherwise `false`.
     */
    @DeleteMapping("{workerId}")
    public boolean deleteUser(@PathVariable UUID workerId){
        return userService.deleteUser(workerId);
    }

    /**
     *
     * @param workerId Worker's ID.
     * @param userRequestPutDto DTO containing updated user information.
     * @return `true` if the user update is successful, otherwise `false`.
     */
    @PutMapping("{workerId}")
    public boolean updateUser(@PathVariable UUID workerId, @Valid @RequestBody UserRequestPutDto userRequestPutDto){
        return userService.updateUser(workerId, userRequestPutDto);
    }
}
