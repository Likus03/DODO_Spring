package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.UserWorkerDTO;
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
    public boolean createUser(@RequestBody UserWorkerDTO request) {
        return userService.create(request);
    }

    @DeleteMapping("user/{id}")
    public boolean deleteUser(@PathVariable UUID id){
        return userService.delete(id);
    }


}
