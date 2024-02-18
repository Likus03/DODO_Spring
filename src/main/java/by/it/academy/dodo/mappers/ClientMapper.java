package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.entities.Client;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Mapper interface for converting between {@link ClientDto} and {@link Client}.
 */
@Component
@Mapper(componentModel = "spring")
public interface ClientMapper {

    /**
     * Converts a {@link ClientDto} to a {@link Client}.
     *
     * @param clientDTO The {@link ClientDto} to convert.
     * @return The corresponding {@link Client} entity.
     */
    Client mapToClient(ClientDto clientDTO);

    /**
     * Converts a {@link Client} entity to a {@link ClientDto}.
     *
     * @param client The {@link Client} entity to convert.
     * @return The corresponding {@link ClientDto}.
     */
    ClientDto mapToClientDto(Client client);
}