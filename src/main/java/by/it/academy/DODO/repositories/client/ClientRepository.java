package by.it.academy.DODO.repositories.client;

import by.it.academy.DODO.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
