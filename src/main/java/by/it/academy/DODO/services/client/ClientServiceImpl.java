package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.response.client.ClientResponseDTO;
import by.it.academy.DODO.entities.Client;
import by.it.academy.DODO.mappers.ClientMapper;
import by.it.academy.DODO.repositories.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public boolean create(ClientResponseDTO clientResponseDTO) {
        Client client = clientMapper.createClient(clientResponseDTO);
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        try {
            clientRepository.deleteById(id);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ClientResponseDTO get(UUID id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return clientMapper.createClientDTO(client);
        }
        return null;
    }

    @Override
    public boolean update(UUID id, ClientResponseDTO clientResponseDTO) {
        Client newClient = clientMapper.createClient(clientResponseDTO);
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            Client oldClient = optionalClient.get();
            setUpdatingClient(newClient, oldClient);
            clientRepository.save(oldClient);
            return true;
        }
        return false;
    }

    private void setUpdatingClient(Client newClient, Client oldClient) {
        oldClient.setFirstname(newClient.getFirstname());
        oldClient.setEmail(newClient.getEmail());
    }
}
