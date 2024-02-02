package by.it.academy.DODO.controllers;

import by.it.academy.DODO.entities.Order;
import by.it.academy.DODO.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("user/{id}")
    public Order getOrder(@PathVariable Long id) {
//        orderService.completeOrder(id);
        Order order = new Order("dehywefbui");
        return order;
    }
}
