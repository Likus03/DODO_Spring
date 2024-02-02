package by.it.academy.DODO.services.order;

import by.it.academy.DODO.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface OrderService {
//    List<OrderDTO> readAvailableOrder();
    List<OrderDTO> getOrdersByParameters(UUID id, boolean completed);
    boolean takeOrder(UUID idOrder, UUID idWorker);
//    boolean create(OrderDTO request);
    boolean completeOrder(UUID id);
//    Order findById(UUID id);
}
