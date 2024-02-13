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
    public boolean create(@Valid @RequestBody UserWorkerRequestDTO userWorkerRequestDTO) {
        return userService.createUser(userWorkerRequestDTO);
    }
    @DeleteMapping("user/{idWorker}")
    public boolean delete(@PathVariable UUID idWorker){
        return userService.deleteUser(idWorker);
    }

    @PatchMapping("user/{idWorker}")
    public boolean update(@PathVariable UUID idWorker, @Valid @RequestBody UserRequestDTO userRequestDTO){
        return userService.updateUser(idWorker, userRequestDTO);
    }
}
