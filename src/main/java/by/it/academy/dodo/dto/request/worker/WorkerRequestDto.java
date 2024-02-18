package by.it.academy.dodo.dto.request.worker;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) for receiving worker-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerRequestDto {
    /**
     * The unique identifier of the worker.
     */
    @NotNull(message = "id cannot be null")
    private UUID id;
}
