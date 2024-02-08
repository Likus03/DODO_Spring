package by.it.academy.DODO.dto.request.order;

import by.it.academy.DODO.dto.request.menu.MenuRequestDTO;
import by.it.academy.DODO.entities.Client;
import by.it.academy.DODO.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private String address;
    private LocalDateTime deliveryTime;
    private Boolean completed;
    private Client client;
    private Worker worker;
    private List<MenuRequestDTO> menus;
}
