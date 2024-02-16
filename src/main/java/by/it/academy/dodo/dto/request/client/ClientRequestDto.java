package by.it.academy.dodo.dto.request.client;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {
    @NotNull(message = "id cannot be null")
    private UUID id;
}
