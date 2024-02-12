package by.it.academy.DODO.dto.request;

import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkerRequestDTO {
    @NotNull(message = "information about user cannot be null")
    UserRequestDTO userRequestDTO;

    @NotNull(message = "information about worker cannot be null")
    WorkerRequestDTO workerRequestDTO;
}
