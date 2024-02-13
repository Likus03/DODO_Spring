package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;

import java.util.UUID;

public interface ClientService {
    boolean createClient(ClientDTO clientDTO);
    boolean saveClient(Client client);
    boolean deleteClient(UUID id);
    ClientDTO getClient(UUID id);
    boolean updateClient(UUID id, ClientDTO clientDTO);

}
