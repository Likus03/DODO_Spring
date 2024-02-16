package by.it.academy.dodo.repositories.order;

import java.util.UUID;

public interface OrderRepositoryCustom {
    boolean getOrder(UUID orderId, UUID workerId);

    boolean completeOrder(UUID id);
}
