package by.it.academy.dodo.dto;

import by.it.academy.dodo.enums.WorkerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for receiving worker-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class WorkerDto {
    /**
     * The first name of the worker.
     */
    @NotBlank(message = "Firstname cannot be null")
    private String firstname;

    /**
     * The surname of the worker.
     */
    @NotBlank(message = "Surname cannot be null")
    private String surname;

    /**
     * The phone number of the worker. Should start with '+' and be no more than 15 characters long.
     */
    @NotBlank(message = "Phone number cannot be null")
    @Pattern(regexp = "^\\+\\d{1,14}$", message = "Phone number should start with '+' and be no more than 15 characters long")
    private String phoneNumber;

    /**
     * The type of the worker.
     */
    @NotNull(message = "Worker type cannot be null")
    private WorkerType workerType;
}
