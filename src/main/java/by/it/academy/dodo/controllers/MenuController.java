package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.services.menu.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * The `MenuController` class provides RESTful endpoints for managing menu-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/menu/dish - Create a new menu.</li>
 *   <li>GET /api/v1/menu - Retrieve all menu information.</li>
 *   <li>GET /api/v1/menu?name - Retrieve menu information by name.</li>
 *   <li>GET /api/v1/menu?description - Retrieve menu information by description.</li>
 *   <li>PUT /api/v1/menu/dish/{id} - Update menu information by ID.</li>
 *   <li>DELETE /api/v1/menu/dish/{id} - Delete a menu by ID.</li>
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
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;

    /**
     * Create a new menu.
     *
     * @param dishDTO The menu data to be created.
     * @return `true` if the menu is successfully created.
     * In case of an error, returns error message.
     */
    @PostMapping("dish")
    @Async
    public CompletableFuture<Boolean> createDish(@Valid @RequestBody DishDto dishDTO) {
        return CompletableFuture.completedFuture(menuService.createDish(dishDTO));
    }

    /**
     * Retrieve menu information.
     *
     * @return The list of {@link DishDto} containing the menu information.
     */
    @GetMapping
    public List<DishDto> getMenu() {
        return menuService.getMenu();
    }

    @GetMapping("dish/{id}")
    public DishDto getMenuById(@PathVariable UUID id) {
        return menuService.getMenuById(id);
    }
    /**
     * Delete a menu by ID.
     *
     * @param id Menu's ID.
     * @return `true` if the menu is successfully deleted, otherwise `false`.
     */
    @DeleteMapping("dish/{id}")
    public boolean deleteDish(@PathVariable UUID id) {
        return menuService.deleteDish(id);
    }

    /**
     * Update menu information by ID.
     *
     * @param id         Menu's ID.
     * @param dishDTO  The updated menu data.
     * @return `true` if the menu is successfully updated, otherwise `false`.
     */
    @PutMapping("dish/{id}")
    public boolean updateDish(@PathVariable UUID id, @Valid @RequestBody DishDto dishDTO) {
        return menuService.updateDish(id, dishDTO);
    }

    /**
     * Retrieve menu information by name.
     *
     * @param name The parameter for filtering menu items.
     * @return The list of {@link DishDto} containing the menu information.
     */
    @GetMapping(value = "dish", params = "name")
    public List<DishDto> getDishByName(@RequestParam String name) {
        return menuService.getDishByName(name);
    }

    /**
     * Retrieve menu information by description.
     *
     * @param description The parameter for filtering menu items.
     * @return The list of {@link DishDto} containing the menu information.
     */
    @GetMapping(value = "dish", params = "description")
    public List<DishDto> getDishByDescription(@RequestParam String description) {
        return menuService.getDishByDescription(description);
    }

}
