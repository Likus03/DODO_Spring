package by.it.academy.DODO.services.order;

import by.it.academy.DODO.entities.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> readAvailableOrder();
    List<Order> readCompletedOrNot(UUID id, boolean completed);
    boolean takeOrder(UUID idOrder, UUID idWorker);
    boolean create(Order order);
    boolean completeOrder(UUID id);
    Order findById(UUID id);
}
