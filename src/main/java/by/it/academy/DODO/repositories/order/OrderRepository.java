package by.it.academy.DODO.repositories.order;

import by.it.academy.DODO.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @NonNull
    Optional<List<Order>> findAllByWorker_IdAndCompleted(@Nullable UUID worker_id, @NonNull Boolean completed);
}
