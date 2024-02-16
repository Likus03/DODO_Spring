package by.it.academy.dodo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) for representing menu information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {

    /**
     * The name of the menu item.
     */
    @NotBlank(message = "Name cannot be null")
    private String name;

    /**
     * The description of the menu item.
     */
    @NotBlank(message = "Describe cannot be null")
    private String description;

    /**
     * The cost of the menu item.
     */
    @NotNull(message = "Cost cannot be null")
    @PositiveOrZero(message = "Cost cannot be negative")
    private BigDecimal cost;
}

