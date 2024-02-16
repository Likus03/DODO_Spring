package by.it.academy.dodo.dto.request;

import by.it.academy.dodo.dto.WorkerDto;
import by.it.academy.dodo.dto.request.user.UserRequestDto;
import jakarta.validation.Valid;
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
    @Valid
    private UserRequestDto user;

    /**
     * Information about the worker.
     */
    @Valid
    private WorkerDto worker;

}
