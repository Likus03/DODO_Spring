package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client createClient(ClientDTO clientDTO);
    ClientDTO createClientDTO(Client client);
}
