package by.it.academy.DODO.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @NotEmpty(message = "Describe cannot be null")
    private String describe;

    @NotNull(message = "Cost cannot be null")
    @PositiveOrZero(message = "Cost cannot be negative")
    private Float cost;
}
