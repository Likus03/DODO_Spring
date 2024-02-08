package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.response.menu.MenuResponseDTO;
import by.it.academy.DODO.services.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("menu")
    public boolean create(@RequestBody MenuResponseDTO menuResponseDTO) {
        return menuService.create(menuResponseDTO);
    }
}
