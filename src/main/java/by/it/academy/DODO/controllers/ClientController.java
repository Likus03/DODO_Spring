package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("client")
    public boolean create(@Valid @RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @GetMapping("client/{id}")
    public ClientDTO get(@PathVariable UUID id) {
        return clientService.getClient(id);
    }

    @PatchMapping("client/{id}")
    public boolean update(@PathVariable UUID id, @Valid @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("client/{id}")
    public boolean delete(@PathVariable UUID id) {
        return clientService.deleteClient(id);
    }
}
