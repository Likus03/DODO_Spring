package by.it.academy.dodo.dto.request.order;

import by.it.academy.dodo.dto.request.client.ClientRequestDto;
import by.it.academy.dodo.dto.request.menu.MenuRequestDto;
import by.it.academy.dodo.dto.request.worker.WorkerRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
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
public class OrderRequestDto {
    /**
     * The delivery address for the order.
     */
    @NotBlank(message = "Address cannot be null")
    private String address;

    /**
     * The date and time for the delivery, which must be in the future or present.
     */
    @FutureOrPresent(message = "Delivery date and time cannot be in past")
    private LocalDateTime deliveryTime;

    /**
     * The client associated with the order.
     */
    @Valid
    private ClientRequestDto client;

    /**
     * The worker associated with the order.
     */
    private WorkerRequestDto worker;

    /**
     * The list of menu items included in the order.
     */
    @Valid
    private List<MenuRequestDto> menus;
}
