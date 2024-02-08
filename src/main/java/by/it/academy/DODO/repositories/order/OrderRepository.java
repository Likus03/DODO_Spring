package by.it.academy.DODO.repositories.order;

import by.it.academy.DODO.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @NonNull
    Optional<List<Order>> findAllByWorker_IdAndCompleted(@Nullable UUID worker_id, @NonNull Boolean completed);

    @NonNull
    @Query(value = "SELECT COALESCE(SUM(menus.cost), 0) from menus inner join order_describes on menus.id = order_describes.menu_id inner join orders on orders.id = order_describes.order_id where order_describes.order_id = :parameter", nativeQuery = true)
    Optional<Float> getTotalCost(@Nullable @Param("parameter")UUID id);
}
