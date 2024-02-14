package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.services.menu.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
/**
 * The `MenuController` class provides RESTful endpoints for managing menu-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/menu - Create a new menu.</li>
 *   <li>GET /api/v1/menu - Retrieve all menu information.</li>
 *   <li>GET /api/v1/menu/{parameter} - Retrieve menu information by parameter.</li>
 *   <li>PUT /api/v1/menu/{id} - Update menu information by ID.</li>
 *   <li>DELETE /api/v1/menu/{id} - Delete a menu by ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link MenuService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link MenuService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MenuController {
    private final MenuService menuService;

    /**
     * Create a new menu.
     *
     * @param menuDTO The menu data to be created.
     * @return `true` if the menu is successfully created.
     *          In case of an error, returns error message.
     */
    @PostMapping("menu")
    public boolean create(@Valid @RequestBody MenuDTO menuDTO) {
        return menuService.createMenu(menuDTO);
    }

    /**
     * Retrieve menu information.
     *
     * @return The list {@link MenuDTO} containing the menu information.
     */
    @GetMapping("menu")
    public List<MenuDTO> getAll() {
        return menuService.getAllMenu();
    }

    /**
     * Delete a menu by ID.
     *
     * @param id Menu's ID.
     * @return `true` if the menu is successfully deleted.
     * In case of an error, returns error message.
     */
    @DeleteMapping("menu/{id}")
    public boolean delete(@PathVariable UUID id) {
        return menuService.deleteMenu(id);
    }

    /**
     * Update menu information by ID.
     *
     * @param id         Menu's ID.
     * @param menuDTO  The updated menu data.
     * @return `true` if the menu is successfully updated.
     *          In case of an error, returns error message.
     */
    @PutMapping("menu/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody MenuDTO menuDTO) {
        return menuService.updateMenu(id, menuDTO);
    }

    /**
     * Retrieve menu information by parameter.
     *
     * @param parameter The parameter for filtering menu items.
     * @return The list of {@link MenuDTO} containing the menu information.
     */
    @GetMapping("menu/{parameter}")
    public List<MenuDTO> getByParameter(@PathVariable String parameter) {
        return menuService.getMenuByParameter(parameter);
    }
}
