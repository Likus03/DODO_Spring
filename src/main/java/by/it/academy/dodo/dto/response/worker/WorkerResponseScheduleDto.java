package by.it.academy.dodo.dto.response.worker;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerResponseScheduleDto {
    /**
     * First name of the worker.
     */
    private String firstname;

    /**
     * Surname of the worker.
     */
    private String surname;
}
