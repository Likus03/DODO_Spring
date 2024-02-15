package by.it.academy.DODO.dto.request;

import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.dto.WorkerDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for receiving combined requests containing user and worker information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkerRequestDTO {

    /**
     * Information about the user.
     */
    @NotNull(message = "Information about user cannot be null")
    private UserRequestDTO userRequestDTO;

    /**
     * Information about the worker.
     */
    @NotNull(message = "Information about worker cannot be null")
    private WorkerDTO workerDTO;
}
