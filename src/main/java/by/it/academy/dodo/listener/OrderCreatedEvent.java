package by.it.academy.dodo.listener;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {
    private final ObjectId orderId;
    public OrderCreatedEvent(Object source, ObjectId orderId) {
        super(source);
        this.orderId = orderId;
    }

    public ObjectId getOrderId() {
        return orderId;
    }
}
