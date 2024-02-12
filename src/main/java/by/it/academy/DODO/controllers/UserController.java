package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.services.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    @PostMapping("user")
    public boolean createUser(@Valid @RequestBody UserWorkerRequestDTO request) {
        return userService.create(request);
    }

    @DeleteMapping("user/{idWorker}")
    public boolean deleteUser(@PathVariable UUID idWorker){
        return userService.delete(idWorker);
    }

    @PatchMapping("user/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody UserRequestDTO userRequestDTO){
        return userService.update(id, userRequestDTO);
    }
}
