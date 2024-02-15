package by.it.academy.dodo;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.services.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrderServiceTests {

    private final OrderService orderService;

    @Autowired
    public OrderServiceTests(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    @Transactional
    public void testTakeOrder() {
        boolean realResultWithRandomIds = orderService.takeOrder(UUID.randomUUID(), UUID.randomUUID());
        boolean realResultWithoutIdWorker = orderService.takeOrder(UUID.fromString("c76ed671-8090-4b15-9f48-0fe26bef6b42"), UUID.randomUUID());
        boolean realResultWithoutIdOrder = orderService.takeOrder(UUID.randomUUID(), UUID.fromString("7aab5d8d-4965-49b8-a386-87b568823e4e"));

        assertFalse(realResultWithRandomIds);
        assertFalse(realResultWithoutIdOrder);
        assertFalse(realResultWithoutIdWorker);
    }

    @Test
    @Transactional
    public void testCreateOrder() {
        assertThrows(DataIntegrityViolationException.class, () ->
                orderService.createOrder(new OrderRequestDto()));
    }

    @Test
    @Transactional
    public void testCompleteOrder() {
        assertThrows(ClientInvalidDataException.class, () ->
                orderService.completeOrder(UUID.randomUUID()));
    }
    @Test
    @Transactional
    public void testSave(){
        assertThrows(DataIntegrityViolationException.class, () ->
                orderService.saveOrder(new Order()));
    }

}
