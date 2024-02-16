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

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public boolean createClient(ClientDto clientDTO) throws DataIntegrityViolationException {
        Client client = clientMapper.mapToClient(clientDTO);
        return saveClient(client);
    }

    @Override
    @Transactional
    public boolean saveClient(Client client) throws DataIntegrityViolationException {
        try {
            clientRepository.saveAndFlush(client);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save client");
        }
    }

    @Override
    @Transactional
    public boolean deleteClient(UUID id) {
        return clientRepository.deleteClient(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto getClient(UUID id) throws ClientInvalidDataException {
        return clientRepository.findById(id)
                .map(clientMapper::mapToClientDto)
                .orElseThrow(() -> new ClientInvalidDataException("Client does not exist"));
    }

    @Override
    @Transactional
    public boolean updateClient(UUID id, ClientDto clientDTO) {
        Client newClient = clientMapper.mapToClient(clientDTO);
        return clientRepository.updateClient(id, newClient);
    }
}
