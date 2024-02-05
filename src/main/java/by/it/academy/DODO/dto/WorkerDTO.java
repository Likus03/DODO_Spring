package by.it.academy.DODO.dto;

import by.it.academy.DODO.WorkerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {
    String firstname;
    String surname;
    String phoneNumber;
    WorkerType workerType;
}
