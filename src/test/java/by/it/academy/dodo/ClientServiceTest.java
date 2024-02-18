package by.it.academy.dodo;

import by.it.academy.dodo.entities.Client;
import by.it.academy.dodo.services.client.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClientServiceTest {
    private final ClientService clientService;

    @Autowired
    public ClientServiceTest(ClientService clientService) {
        this.clientService = clientService;
    }

    @Test
    @Transactional
    public void testDeleteNonExistingClientById() {
        assertFalse(clientService.deleteClient(UUID.randomUUID()));
    }

    @Test
    @Transactional
    public void testSaveClientInvalidData() {
        assertThrows(DataIntegrityViolationException.class, () ->
                clientService.saveClient(new Client()));
    }
}
