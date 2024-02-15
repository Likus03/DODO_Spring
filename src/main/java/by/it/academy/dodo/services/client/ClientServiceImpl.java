package by.it.academy.dodo.services.client;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.ClientMapper;
import by.it.academy.dodo.repositories.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    /**
     * Creates a new client based on the provided {@link ClientDto}.
     *
     * @param clientDTO The client data to create.
     * @return {@code true} if the client is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    @Override
    @Transactional
    public boolean createClient(ClientDto clientDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (clientDTO != null) {
            Client client = clientMapper.createClient(clientDTO);
            return saveClient(client);
        }
        throw new ClientInvalidDataException("Unable to create client");
    }
    /**
     * Saves the provided client to the repository.
     *
     * @param client The client to save.
     * @return {@code true} if the client is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    @Override
    @Transactional
    public boolean saveClient(Client client) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (client != null) {
            try {
                clientRepository.saveAndFlush(client);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save client");
            }
        }
        throw new ClientInvalidDataException("Unable to save client");
    }

    /**
     * Deletes the client with the specified ID.
     *
     * @param id The ID of the client to delete.
     * @return {@code true} if the client is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the client data is invalid.
     */
    @Override
    @Transactional
    public boolean deleteClient(UUID id) throws ClientInvalidDataException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Client was not found"));
        clientRepository.delete(client);
        return true;
    }
    /**
     * Retrieves the client with the specified ID.
     *
     * @param id The ID of the client to retrieve.
     * @return The client with the specified ID.
     * @throws ClientInvalidDataException If the client data is invalid.
     */
    @Override
    @Transactional(readOnly = true)
    public ClientDto getClient(UUID id) throws ClientInvalidDataException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return clientMapper.createClientDTO(client);
        }
        throw new ClientInvalidDataException("Client does not exist");
    }
    /**
     * Updates the client with the specified ID using the provided {@link ClientDto}.
     *
     * @param id        The ID of the client to update.
     * @param clientDTO The updated client data.
     * @return {@code true} if the client is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the client data is invalid.
     */
    @Override
    @Transactional
    public boolean updateClient(UUID id, ClientDto clientDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (clientDTO != null) {
            Client newClient = clientMapper.createClient(clientDTO);
            Optional<Client> optionalClient = clientRepository.findById(id);
            if (optionalClient.isPresent()) {
                Client oldClient = optionalClient.get();
                setUpdatingClient(newClient, oldClient);

                return saveClient(oldClient);
            }
            throw new ClientInvalidDataException("Client was not found");
        }
        throw new ClientInvalidDataException("Unable to update client");
    }
    /**
     * Sets up the updating of the client with new client data.
     *
     * @param newClient The new client data.
     * @param oldClient The existing client data.
     */
    private void setUpdatingClient(Client newClient, Client oldClient) {
        oldClient.setFirstname(newClient.getFirstname());
        oldClient.setEmail(newClient.getEmail());
    }
}
