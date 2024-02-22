package by.it.academy.dodo.dto.response.order;

import by.it.academy.dodo.dto.DishDto;
import by.it.academy.dodo.dto.response.client.ClientToOrderResponseDto;
import by.it.academy.dodo.dto.response.worker.WorkerResponseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Data Transfer Object (DTO) for representing client information in the context of an order response.
 */
@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class OrderResponseDto {
    /** The delivery address for the order. */
    private String address;

    /** The scheduled delivery time for the order. */
    private LocalDateTime deliveryTime;

    /** Indicates whether the order has been completed or not. */
    private Boolean isCompleted;

    /** The total cost of the order. */
    private Float totalCost;

    /** Details about the client placing the order. */
    private ClientToOrderResponseDto client;

    /** Details about the worker assigned to the order. */
    private WorkerResponseDto worker;

    /** The list of menu items included in the order. */
    private List<DishDto> menus;
}
