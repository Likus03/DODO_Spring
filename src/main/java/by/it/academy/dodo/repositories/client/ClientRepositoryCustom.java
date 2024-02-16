package by.it.academy.dodo.repositories.client;

import by.it.academy.dodo.entities.Client;

import java.util.UUID;

public interface ClientRepositoryCustom {

    /**
     * Deletes a client with the specified ID.
     *
     * @param id The ID of the client to be deleted.
     * @return True if the client is deleted successfully, false otherwise.
     */
    boolean deleteClient(UUID id);

    /**
     * Updates a client with the specified ID.
     *
     * @param id       The ID of the client to be updated.
     * @param newClient The updated Client object.
     * @return True if the client is updated successfully, false otherwise.
     */
    boolean updateClient(UUID id, Client newClient);
}
