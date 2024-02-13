package by.it.academy.DODO;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.entities.Client;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.ClientMapper;
import by.it.academy.DODO.services.client.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientServiceTests {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Autowired
    public ClientServiceTests(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @Test
    @Transactional
    public void testCreate() {
        assertThrows(DataIntegrityViolationException.class, () ->
        {
            clientService.createClient(new ClientDTO());
        });
    }

    @Test
    @Transactional
    public void testGet() {
        ClientDTO realResult = clientService.getClient(UUID.fromString("064bdc47-7013-4528-84d5-9ab1cd550eb4"));
        ClientDTO expectedResult = clientMapper.createClientDTO(
                new Client(
                        UUID.fromString("064bdc47-7013-4528-84d5-9ab1cd550eb4"),
                        "Alex", "+375442583415",
                        "akex@gmail.com",
                        LocalDate.parse("1999-05-28")
                ));
        assertEquals(realResult, expectedResult);
    }

    @Test
    @Transactional
    public void testUpdate() {
        assertThrows(ClientInvalidDataException.class, () ->
        {
            clientService.updateClient(UUID.randomUUID(),
                    clientMapper.createClientDTO(new Client(
                            UUID.fromString("064bdc47-7013-4528-84d5-9ab1cd550eb4"),
                            "Alex",
                            "+375442583415",
                            "akex@gmail.com",
                            LocalDate.parse("1999-05-28"))
                    ));
        });

        assertThrows(DataIntegrityViolationException.class, () ->
        {
            clientService.updateClient(UUID.fromString("064bdc47-7013-4528-84d5-9ab1cd550eb4"), new ClientDTO());
        });
    }

    @Test
    @Transactional
    public void testDelete() {
        assertThrows(ClientInvalidDataException.class, () ->
        {
            clientService.deleteClient(UUID.randomUUID());
        });
    }

    @Test
    @Transactional
    public void testSave(){
        assertThrows(DataIntegrityViolationException.class, () ->
        {
            clientService.saveClient(new Client());
        });
    }
}
