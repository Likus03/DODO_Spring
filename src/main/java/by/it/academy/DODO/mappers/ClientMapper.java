package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting between {@link ClientDTO} and {@link Client}.
 */
@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {

    /**
     * Converts a {@link ClientDTO} to a {@link Client}.
     *
     * @param clientDTO The {@link ClientDTO} to convert.
     * @return The corresponding {@link Client} entity.
     */
    Client createClient(ClientDTO clientDTO);

    /**
     * Converts a {@link Client} entity to a {@link ClientDTO}.
     *
     * @param client The {@link Client} entity to convert.
     * @return The corresponding {@link ClientDTO}.
     */
    ClientDTO createClientDTO(Client client);
}