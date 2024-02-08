package by.it.academy.DODO.dto.response.order;

import by.it.academy.DODO.dto.response.client.ClientToOrderResponseDTO;
import by.it.academy.DODO.dto.MenuDTO;
import by.it.academy.DODO.dto.request.worker.WorkerToOrderRequestDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderResponseDTO {
    private String address;
    private LocalDateTime deliveryTime;
    private Boolean completed;
    private Float totalCost;
    private ClientToOrderResponseDTO client;
    private WorkerToOrderRequestDTO worker;
    private List<MenuDTO> menus;
}
