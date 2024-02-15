package by.it.academy.dodo.services.order;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderResponseDto> getOrdersByParameters(UUID id, boolean completed);
    boolean takeOrder(UUID idOrder, UUID idWorker);
    boolean createOrder(OrderRequestDto orderRequestDTO);
    boolean saveOrder(Order order);
    boolean completeOrder(UUID id);
}
