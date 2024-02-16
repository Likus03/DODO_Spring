package by.it.academy.dodo.services.client;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public interface ClientService {
    /**
     * Creates a new client based on the provided {@link ClientDto}.
     *
     * @param clientDTO The client data to create.
     * @return {@code true} if the client is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    boolean createClient(ClientDto clientDTO);

    /**
     * Saves the provided client to the repository.
     *
     * @param client The client to save.
     * @return {@code true} if the client is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    boolean saveClient(Client client);

    /**
     * Deletes the client with the specified ID.
     *
     * @param id The ID of the client to delete.
     * @return {@code true} if the client is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the client data is invalid.
     */
    boolean deleteClient(UUID id);

    /**
     * Retrieves the client with the specified ID.
     *
     * @param id The ID of the client to retrieve.
     * @return The client with the specified ID.
     * @throws ClientInvalidDataException If the client data is invalid.
     */
    ClientDto getClient(UUID id);

    /**
     * Updates the client with the specified ID using the provided {@link ClientDto}.
     *
     * @param id        The ID of the client to update.
     * @param clientDTO The updated client data.
     * @return {@code true} if the client is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    boolean updateClient(UUID id, ClientDto clientDTO);

}
