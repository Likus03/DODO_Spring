package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface ClientService {
    boolean create(ClientDTO clientDTO);

    @Transactional
    boolean save(Client client);

    boolean delete(UUID id);

    ClientDTO get(UUID id);

    boolean update(UUID id, ClientDTO clientDTO);

}
