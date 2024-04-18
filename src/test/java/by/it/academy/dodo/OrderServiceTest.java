package by.it.academy.dodo;

import by.it.academy.dodo.entities.Order;
import by.it.academy.dodo.services.order.OrderService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrderServiceTest {

    private final OrderService orderService;

    @Autowired
    public OrderServiceTest(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    @Transactional
    public void testGetOrderWithNonExistingIds() {
        boolean realResultWithRandomIds = orderService.getOrder(ObjectId.get(), ObjectId.get());
        assertFalse(realResultWithRandomIds);
    }
    @Test
    @Transactional
    public void testCompleteOrderWithNonExistingId() {
        assertFalse(orderService.completeOrder(ObjectId.get()));
    }
    @Test
    @Transactional
    public void testSaveOrderInvalidData(){
        assertThrows(DataIntegrityViolationException.class, () ->
                orderService.saveOrder(new Order()));
    }

}
