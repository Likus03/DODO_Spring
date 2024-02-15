package by.it.academy.dodo.dto.request;

import by.it.academy.dodo.dto.request.user.UserRequestDto;
import by.it.academy.dodo.dto.WorkerDto;
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
public class UserWorkerRequestDto {

    /**
     * Information about the user.
     */
    @NotNull(message = "Information about user cannot be null")
    private UserRequestDto userRequestDTO;

    /**
     * Information about the worker.
     */
    @NotNull(message = "Information about worker cannot be null")
    private WorkerDto workerDTO;

}
