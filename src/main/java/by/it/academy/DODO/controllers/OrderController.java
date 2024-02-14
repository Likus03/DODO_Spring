package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.services.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
/**
 * The `OrderController` class provides RESTful endpoints for managing order-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/order - Create a new order.</li>
 *   <li>GET /api/v1/worker/{id}/orders/status/notCompleted - Retrieve a list of incomplete orders for a specific worker.</li>
 *   <li>GET /api/v1/worker/{id}/orders/status/completed - Retrieve a list of completed orders for a specific worker.</li>
 *   <li>GET /api/v1/orders/status/available - Retrieve a list of available orders.</li>
 *   <li>PATCH /api/v1/order/{id} - Complete an order by its identifier.</li>
 *   <li>PATCH /api/v1/worker/{idWorker}/order/{idOrder} - Acceptance of an order by an worker using the ID worker and ID order.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link OrderService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link OrderService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;

    /**
     * Retrieve a list of incomplete orders for a specific worker.
     *
     * @param id The ID of the order to retrieve.
     * @return The list of {@link OrderResponseDTO} containing the order's information.
     */
    @GetMapping("worker/{id}/orders/status/notCompleted")
    public List<OrderResponseDTO> getNotCompleted(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, false);
    }

    /**
     * Retrieve a list of completed orders for a specific worker.
     *
     * @param id The ID of the order to retrieve.
     * @return The list of {@link OrderResponseDTO} containing the order's information.
     */
    @GetMapping("worker/{id}/orders/status/completed")
    public List<OrderResponseDTO> getCompleted(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, true);
    }

    /**
     * Retrieve a list of available orders.
     *
     * @return The list of {@link OrderResponseDTO} containing the order's information.
     */
    @GetMapping("orders/status/available")
    public List<OrderResponseDTO> getAvailable() {
        return orderService.getOrdersByParameters(null, false);
    }

    /**
     * Complete an order by ID.
     *
     * @param id Order's ID.
     * @return `true` if the order is successfully updated.
     * In case of an error, returns error message.
     */
    @PatchMapping("order/{id}")
    public boolean completeOrder(@PathVariable UUID id) {
        return orderService.completeOrder(id);
    }

    /**
     * Acceptance of an order by a worker using the ID worker and ID order.
     * @param idWorker Worker's ID.
     * @param idOrder Order's ID.
     * @return   Result of order acceptance `true` if the order is successfully updated.
     * In case of an error, returns error message.
     */
    @PatchMapping("worker/{idWorker}/order/{idOrder}")
    public boolean takeOrder(@PathVariable UUID idWorker, @PathVariable UUID idOrder) {
        return orderService.takeOrder(idOrder, idWorker);
    }

    /**
     * Create a new order.
     * @param orderRequestDTO The order data to be created.
     * @return Result of order acceptance `true` if the order is successfully created.
     * In case of an error, returns error message.
     */
    @PostMapping("order")
    public boolean create(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}
