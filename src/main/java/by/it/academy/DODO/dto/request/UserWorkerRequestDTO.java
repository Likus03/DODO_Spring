package by.it.academy.DODO.dto.request;

import by.it.academy.DODO.dto.request.worker.WorkerRequestDTO;
import by.it.academy.DODO.dto.request.user.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWorkerRequestDTO {
    UserRequestDTO userRequestDTO;
    WorkerRequestDTO workerRequestDTO;
}
