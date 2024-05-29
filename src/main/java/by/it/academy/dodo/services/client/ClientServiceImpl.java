package by.it.academy.dodo.services.client;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.ClientMapper;
import by.it.academy.dodo.repositories.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public void createClient(ClientDto clientDTO) throws DataIntegrityViolationException {
        Client client = clientMapper.mapToClient(clientDTO);
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(ObjectId id) {
         clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto getClient(ObjectId id) throws ClientInvalidDataException {
        return clientRepository.findById(id)
                .map(clientMapper::mapToClientDto)
                .orElseThrow(() -> new ClientInvalidDataException("Client does not exist"));
    }

    @Override
    @Transactional
    public void updateClient(ObjectId id, ClientDto clientDTO) {
        Client newClient = clientMapper.mapToClient(clientDTO);
        newClient.setId(id);
        clientRepository.save(newClient);
    }
}
