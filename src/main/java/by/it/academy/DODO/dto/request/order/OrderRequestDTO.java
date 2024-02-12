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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    @NotEmpty(message = "Address cannot be null")
    private String address;

    @FutureOrPresent(message = "Delivery date and time cannot be in past")
    private LocalDateTime deliveryTime;

    @NotNull(message = "Client cannot be null")
    private Client client;

    private Worker worker;

    @NotEmpty
    private List<MenuRequestDTO> menus;
}
