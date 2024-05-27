package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.services.order.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * The `OrderController` class provides RESTful endpoints for managing order-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/order - Create a new order.</li>
 *   <li>GET /api/v1/worker/{workerId}/orders?IsCompleted - Retrieve a list of orders for a specific worker by status.</li>
 *   <li>GET /api/v1/available-orders - Retrieve a list of available orders.</li>
 *   <li>PUT /api/v1/order/{id} - Complete an order by its identifier.</li>
 *   <li>PUT /api/v1/worker/{workerId}/order/{orderId} - Acceptance of an order by an worker using the ID worker and ID order.</li>
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
     * Retrieve a list of orders for a specific worker by status.
     *
     * @param workerId The ID of the order to retrieve.
     * @return The list of {@link OrderResponseDto} containing the order's information.
     */
    @GetMapping(value = "worker/{workerId}/orders", params = "isCompleted")
    public List<OrderResponseDto> getOrdersByStatus(@PathVariable ObjectId workerId, @RequestParam @NotNull boolean isCompleted) {
        return orderService.getOrdersByStatus(workerId, isCompleted);
    }
    /**
     * Retrieve a list of available orders.
     *
     * @return The list of {@link OrderResponseDto} containing the order's information.
     */
    @GetMapping("available-orders")
    public List<OrderResponseDto> getAvailableOrders() {
        return orderService.getAvailableOrders();
    }
    /**
     * Complete an order by ID.
     *
     * @param id Order's ID.
     * @return `true` if the order is successfully updated, otherwise `false`.
     */
    @PutMapping("order/{id}")
    public boolean completeOrder(@PathVariable ObjectId id) {
        return orderService.completeOrder(id);
    }
    /**
     * Acceptance of an order by a worker using the ID worker and ID order.
     * @param workerId Worker's ID.
     * @param orderId Order's ID.
     * @return   Result of order acceptance `true` if the order is successfully updated, otherwise `false`.
     */
    @PutMapping("worker/{workerId}/order/{orderId}")
    public boolean getOrder(@PathVariable ObjectId workerId, @PathVariable ObjectId orderId) {
        return orderService.getOrder(orderId, workerId);
    }
    /**
     * Create a new order.
     * @param orderRequestDTO The order data to be created.
     * @return Result of order acceptance `true` if the order is successfully created.
     * In case of an error, returns error message.
     */
    @PostMapping("order")
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderRequestDto orderRequestDTO) {
        orderService.createOrder(orderRequestDTO);
        return new ResponseEntity<>("Order created successfully", CREATED);
    }
}
