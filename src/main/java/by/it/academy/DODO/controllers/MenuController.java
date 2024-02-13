package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.services.menu.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("menu")
    public boolean create(@Valid @RequestBody MenuDTO menuDTO) {
        return menuService.createMenu(menuDTO);
    }

    @GetMapping("menu")
    public List<MenuDTO> getAll() {
        return menuService.getAllMenu();
    }

    @DeleteMapping("menu/{id}")
    public boolean delete(@PathVariable UUID id) {
        return menuService.deleteMenu(id);
    }

    @PutMapping("menu/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody MenuDTO menuDTO) {
        return menuService.updateMenu(id, menuDTO);
    }

    @GetMapping("menu/{parameter}")
    public List<MenuDTO> getByParameter(@PathVariable String parameter) {
        return menuService.getMenuByParameter(parameter);
    }
}
