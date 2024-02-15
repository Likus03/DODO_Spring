package by.it.academy.dodo.services.client;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;

import java.util.UUID;

public interface ClientService {
    boolean createClient(ClientDto clientDTO);
    boolean saveClient(Client client);
    boolean deleteClient(UUID id);
    ClientDto getClient(UUID id);
    boolean updateClient(UUID id, ClientDto clientDTO);

}
