package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.ClientDTO;
import by.it.academy.DODO.services.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("client")
    public boolean create(@RequestBody ClientDTO clientDTO) {
        return clientService.create(clientDTO);
    }

    @GetMapping("client/{id}")
    public ClientDTO getClient(@PathVariable UUID id) {
        return clientService.get(id);
    }

    @PatchMapping("client/{id}")
    public boolean update(@PathVariable UUID id, @RequestBody ClientDTO clientDTO) {
        return clientService.update(id, clientDTO);
    }

    @DeleteMapping("client/{id}")
    public boolean delete(@PathVariable UUID id) {
        return clientService.delete(id);
    }
}
