package by.it.academy.dodo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing menu information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    /**
     * The name of the menu item.
     */
    @NotEmpty(message = "Name cannot be null")
    private String name;

    /**
     * The description of the menu item.
     */
    @NotEmpty(message = "Describe cannot be null")
    private String describe;

    /**
     * The cost of the menu item.
     */
    @NotNull(message = "Cost cannot be null")
    @PositiveOrZero(message = "Cost cannot be negative")
    private Float cost;
}

