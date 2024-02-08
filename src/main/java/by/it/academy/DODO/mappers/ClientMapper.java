package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.response.client.ClientResponseDTO;
import by.it.academy.DODO.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client createClient(ClientResponseDTO clientResponseDTO);
    ClientResponseDTO createClientDTO(Client client);
}
