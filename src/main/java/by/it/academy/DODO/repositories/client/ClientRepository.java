package by.it.academy.DODO.repositories.client;

import by.it.academy.DODO.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository interface for performing CRUD operations on {@link Client} entities.
 */
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
