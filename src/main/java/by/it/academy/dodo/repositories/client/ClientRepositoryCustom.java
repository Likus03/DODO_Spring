package by.it.academy.dodo.repositories.client;

import by.it.academy.dodo.entities.Client;

import java.util.UUID;

public interface ClientRepositoryCustom {
    boolean deleteClient(UUID id);

    boolean updateClient(UUID id, Client client);
}
