package by.it.academy.DODO.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String describe;
    private Float cost;
    private String address;
    private LocalDateTime deliveryTime;
    private Boolean completed;
}
