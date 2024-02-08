package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.UserWorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    @PostMapping("user")
    public boolean createUser(@RequestBody UserWorkerRequestDTO request) {
        return userService.create(request);
    }

    @DeleteMapping("user/{id}")
    public boolean deleteUser(@PathVariable UUID id){
        return userService.delete(id);
    }

    @PatchMapping("user/{id}")
    public boolean update(@PathVariable UUID id, @RequestBody UserRequestDTO userRequestDTO){
        return userService.update(id, userRequestDTO);
    }
}
