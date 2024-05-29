package by.it.academy.dodo.services.client;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public interface ClientService {
    /**
     * Creates a new client based on the provided {@link ClientDto}.
     *
     * @param clientDTO The client data to create.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     */
    void createClient(ClientDto clientDTO);
    /**
     * Deletes the client with the specified ID.
     *
     * @param id The ID of the client to delete.*/
    void deleteClient(ObjectId id);

    /**
     * Retrieves the client with the specified ID.
     *
     * @param id The ID of the client to retrieve.
     * @return The client with the specified ID.
     * @throws ClientInvalidDataException If the client data is invalid.
     */
    ClientDto getClient(ObjectId id);

    /**
     * Updates the client with the specified ID using the provided {@link ClientDto}.
     *
     * @param id        The ID of the client to update.
     * @param clientDTO The updated client data.
     */
    void updateClient(ObjectId id, ClientDto clientDTO);

}
