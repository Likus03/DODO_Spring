package by.it.academy.dodo.repositories.user;

import by.it.academy.dodo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link User} entities.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Retrieves a user entity based on the worker's ID.
     *
     * @param worker_id The ID of the associated worker.
     * @return An optional list of {@link User} containing the user entity associated with the given worker's ID.
     */
    @NonNull
    Optional<User> findByWorkerId(@NonNull UUID worker_id);
}
