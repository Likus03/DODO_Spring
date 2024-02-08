package by.it.academy.DODO.services.client;

import by.it.academy.DODO.dto.response.client.ClientResponseDTO;

import java.util.UUID;

public interface ClientService {
    boolean create(ClientResponseDTO clientResponseDTO);

    boolean delete(UUID id);

    ClientResponseDTO get(UUID id);

    boolean update(UUID id, ClientResponseDTO clientResponseDTO);
}
