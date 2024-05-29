package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.services.menu.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<String> createDish(@Valid @RequestBody DishDto dishDTO) {
        menuService.createDish(dishDTO);
        return new ResponseEntity<>("Dish created successfully", CREATED);
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

    /**
     * Delete a menu by ID.
     *
     * @param id Menu's ID.
     */
    @DeleteMapping("dish/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable ObjectId id) {
        menuService.deleteDish(id);
        return new ResponseEntity<>("Dish deleted successfully", OK);
    }

    /**
     * Update menu information by ID.
     *
     * @param id      Menu's ID.
     * @param dishDTO The updated menu data.
     * @return `true` if the menu is successfully updated, otherwise `false`.
     */
    @PutMapping("dish/{id}")
    public ResponseEntity<String> updateDish(@PathVariable ObjectId id, @Valid @RequestBody DishDto dishDTO) {
        menuService.updateDish(id, dishDTO);
        return new ResponseEntity<>("Dish updated successfully", OK);
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
