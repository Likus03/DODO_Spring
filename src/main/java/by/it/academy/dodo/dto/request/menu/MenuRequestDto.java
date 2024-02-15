package by.it.academy.dodo.dto.request.menu;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) for receiving menu-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequestDto {
    /**
     * The unique identifier of the menu item.
     */
    @NotNull
    private UUID id;
}
