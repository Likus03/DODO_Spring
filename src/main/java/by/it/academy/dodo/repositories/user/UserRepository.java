package by.it.academy.dodo.repositories.user;

import by.it.academy.dodo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link User} entities.
 */
public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryCustom{

    /**
     * Retrieves a user entity based on the worker's ID.
     *
     * @param workerId The ID of the associated worker.
     * @return An optional list of {@link User} containing the user entity associated with the given worker's ID.
     */
    Optional<User> findByWorkerId(UUID workerId);
}
