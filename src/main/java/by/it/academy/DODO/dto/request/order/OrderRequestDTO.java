package by.it.academy.DODO.dto.request.order;

import by.it.academy.DODO.dto.request.menu.MenuRequestDTO;
import by.it.academy.DODO.entities.Client;
import by.it.academy.DODO.entities.Worker;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) for receiving order-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    /**
     * The delivery address for the order.
     */
    @NotEmpty(message = "Address cannot be null")
    private String address;

    /**
     * The date and time for the delivery, which must be in the future or present.
     */
    @FutureOrPresent(message = "Delivery date and time cannot be in past")
    private LocalDateTime deliveryTime;

    /**
     * The client associated with the order.
     */
    @NotNull(message = "Client cannot be null")
    private Client client;

    /**
     * The worker associated with the order.
     */
    private Worker worker;


    /**
     * The list of menu items included in the order.
     */
    @NotEmpty
    private List<MenuRequestDTO> menus;
}
