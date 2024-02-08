package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.ClientDTO;

import java.util.UUID;

public interface ClientService {
    boolean create(ClientDTO clientDTO);

    boolean delete(UUID id);

    ClientDTO get(UUID id);

    boolean update(UUID id, ClientDTO clientDTO);
}
