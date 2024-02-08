package by.it.academy.DODO.dto.request.worker;

import by.it.academy.DODO.WorkerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerRequestDTO {
    private String firstname;
    private String surname;
    private String phoneNumber;
    private WorkerType workerType;
}
