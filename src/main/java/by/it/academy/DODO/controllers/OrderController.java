package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.OrderDTO;
import by.it.academy.DODO.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("worker/{id}/orders/status/notCompleted")
    public List<OrderDTO> getNotCompletedOrder(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, false);
    }

    @GetMapping("worker/{id}/orders/status/completed")
    public List<OrderDTO> getCompletedOrder(@PathVariable UUID id) {
        return orderService.getOrdersByParameters(id, true);
    }

    @GetMapping("orders/status/available")
    public List<OrderDTO> getAvailableOrder() {
        return orderService.getOrdersByParameters(null, false);
    }
    @PatchMapping("order/{id}")
    public boolean CompleteOrder(@PathVariable UUID id) {
        return orderService.completeOrder(id);
    }

    @PatchMapping("worker/{idWorker}/order/{idOrder}")
    public boolean TakeOrder(@PathVariable UUID idWorker, @PathVariable UUID idOrder){
        return orderService.takeOrder(idOrder, idWorker);
    }
//    @PostMapping("order")
//    public boolean createOrder(@RequestBody OrderDTO request) {
//        return orderService.create(request);
//    }
}
