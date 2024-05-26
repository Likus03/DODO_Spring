package by.it.academy.dodo.dto.request.client;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.UUID;
/**
 * Data Transfer Object (DTO) for receiving work client-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {
    /**
     * The unique identifier of the client.
     */
    @NotNull(message = "id cannot be null")
    private ObjectId id;
}
