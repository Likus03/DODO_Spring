package by.it.academy.dodo.controllers;

import by.it.academy.dodo.dto.ClientDto;
import by.it.academy.dodo.services.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
/**
 * The `ClientController` class provides RESTful endpoints for managing client-related operations.
 *
 * <p>Endpoints:
 * <ul>
 *   <li>POST /api/v1/client - Create a new client.</li>
 *   <li>GET /api/v1/client/{id} - Retrieve client information by ID.</li>
 *   <li>PATCH /api/v1/client/{id} - Update client information by ID.</li>
 *   <li>DELETE /api/v1/client/{id} - Delete a client by ID.</li>
 * </ul>
 *
 * <p>Each method in this class corresponds to a specific API endpoint and delegates the
 * processing to the underlying {@link ClientService} for business logic.
 *
 * <p>This class is annotated with `@RestController`, indicating that it handles HTTP requests
 * and returns the response directly instead of relying on a view resolver.
 *
 * <p>The `@RequestMapping` annotation is used to specify the base URL for all endpoints defined
 * in this class ("/api/v1"). This helps organize and group related endpoints under a common base path.
 *
 * <p>The `@RequiredArgsConstructor` annotation is used to generate a constructor with required
 * fields, in this case, injecting an instance of {@link ClientService}.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;

    /**
     * Create a new client.
     *
     * @param clientDTO The client data to be created.
     * @return `true` if the client is successfully created.
     *          In case of an error, returns error message.
     */
    @PostMapping
    public boolean createClient(@Valid @RequestBody ClientDto clientDTO) {
        return clientService.createClient(clientDTO);
    }

    /**
     * Retrieve client information by ID.
     *
     * @param id Client's ID.
     * @return The {@link ClientDto} containing the client information.
     */
    @GetMapping("{id}")
    public ClientDto getClient(@PathVariable UUID id) {
        return clientService.getClient(id);
    }

    /**
     * Update client information by ID.
     *
     * @param id         Client's ID.
     * @param clientDTO  The updated client data.
     * @return `true` if the client is successfully updated.
     *          In case of an error, returns error message.
     */
    @PutMapping("{id}")
    public boolean updateClient(@PathVariable UUID id, @Valid @RequestBody ClientDto clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    /**
     * Delete a client by ID.
     *
     * @param id Client's ID.
     * @return `true` if the client is successfully deleted.
     * In case of an error, returns error message.
     */
    @DeleteMapping("{id}")
    public boolean deleteClient(@PathVariable UUID id) {
        return clientService.deleteClient(id);
    }
}
