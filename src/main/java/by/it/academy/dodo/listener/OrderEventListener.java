package by.it.academy.dodo.listener;

import by.it.academy.dodo.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final OrderService orderService;

    public void handleOrderCreatedEvent(OrderCreatedEvent event){
        ObjectId orderId = event.getOrderId();
//        orderService.calculateTotalCost(orderId);
    }
}
