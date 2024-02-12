package by.it.academy.DODO.services.order;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.entities.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderResponseDTO> getOrdersByParameters(UUID id, boolean completed);
    boolean takeOrder(UUID idOrder, UUID idWorker);
    boolean create(OrderRequestDTO request);

    boolean save(Order order);

    boolean completeOrder(UUID id);
}
