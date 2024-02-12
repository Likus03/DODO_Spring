package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.services.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("worker/{id}/orders/status/notCompleted")
    public List<OrderResponseDTO> getNotCompletedOrder(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, false);
    }

    @GetMapping("worker/{id}/orders/status/completed")
    public List<OrderResponseDTO> getCompletedOrder(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, true);
    }

    @GetMapping("orders/status/available")
    public List<OrderResponseDTO> getAvailableOrder() {
        return orderService.getOrdersByParameters(null, false);
    }
    @PatchMapping("order/{id}")
    public boolean completeOrder(@PathVariable UUID id) {
        return orderService.completeOrder(id);
    }

    @PatchMapping("worker/{idWorker}/order/{idOrder}")
    public boolean takeOrder(@PathVariable UUID idWorker, @PathVariable UUID idOrder){
        return orderService.takeOrder(idOrder, idWorker);
    }
    @PostMapping("order")
    public boolean createOrder(@Valid @RequestBody OrderRequestDTO request, BindingResult bindingResult) {
        return orderService.create(request);
    }
}
