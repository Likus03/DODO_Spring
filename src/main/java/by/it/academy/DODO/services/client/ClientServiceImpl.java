package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.ClientMapper;
import by.it.academy.DODO.repositories.client.ClientRepository;
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

    @Override
    @Transactional
    public boolean createClient(ClientDTO clientDTO) throws DataIntegrityViolationException{
        Client client = clientMapper.createClient(clientDTO);
        return saveClient(client);
    }

    @Override
    @Transactional
    public boolean saveClient(Client client) throws DataIntegrityViolationException{
        try {
            clientRepository.saveAndFlush(client);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save client");
        }
    }

    @Override
    @Transactional
    public boolean deleteClient(UUID id) throws ClientInvalidDataException{
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Client was not found"));
        clientRepository.delete(client);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDTO getClient(UUID id) throws ClientInvalidDataException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return clientMapper.createClientDTO(client);
        }
        throw new ClientInvalidDataException("Client does not exist");
    }

    @Override
    @Transactional
    public boolean updateClient(UUID id, ClientDTO clientDTO) throws DataIntegrityViolationException, ClientInvalidDataException{
        Client newClient = clientMapper.createClient(clientDTO);
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client oldClient = optionalClient.get();
            setUpdatingClient(newClient, oldClient);

            return saveClient(oldClient);
        }
        throw new ClientInvalidDataException("Client was not found");
    }

    private void setUpdatingClient(Client newClient, Client oldClient) {
        oldClient.setFirstname(newClient.getFirstname());
        oldClient.setEmail(newClient.getEmail());
    }
}
