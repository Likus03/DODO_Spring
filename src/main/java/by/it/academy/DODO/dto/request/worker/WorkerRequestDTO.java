package by.it.academy.DODO.dto.request.worker;

import by.it.academy.DODO.WorkerType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerRequestDTO {
    @NotEmpty(message = "Firstname cannot be null")
    private String firstname;

    @NotEmpty(message = "Surname cannot be null")
    private String surname;

    @Pattern(regexp = "^\\+\\d{1,14}$", message = "Phone number should start with '+' and be no more than 15 long")
    private String phoneNumber;

    @NotNull(message = "Worker type cannot be null")
    private WorkerType workerType;
}
