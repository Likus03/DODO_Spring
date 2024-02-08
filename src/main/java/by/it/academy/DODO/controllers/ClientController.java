package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.response.client.ClientResponseDTO;
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
    public boolean create(@RequestBody ClientResponseDTO clientResponseDTO) {
        return clientService.create(clientResponseDTO);
    }

    @GetMapping("client/{id}")
    public ClientResponseDTO getClient(@PathVariable UUID id) {
        return clientService.get(id);
    }

    @PatchMapping("client/{id}")
    public boolean update(@PathVariable UUID id, @RequestBody ClientResponseDTO clientResponseDTO) {
        return clientService.update(id, clientResponseDTO);
    }

    @DeleteMapping("client/{id}")
    public boolean delete(@PathVariable UUID id) {
        return clientService.delete(id);
    }
}
