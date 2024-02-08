package by.it.academy.DODO.repositories.user;

import by.it.academy.DODO.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @NonNull
    Optional<User> findByWorkerId(@NonNull UUID worker_id);
}
