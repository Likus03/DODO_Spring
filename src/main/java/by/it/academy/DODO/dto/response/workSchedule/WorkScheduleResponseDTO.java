package by.it.academy.DODO.dto.response.workSchedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleResponseDTO {
    private LocalDate dateWork;
    private LocalTime startTime;
    private LocalTime endTime;
    private String surname;
    private String firstname;
}
