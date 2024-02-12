package by.it.academy.DODO.dto.request.workSchedule;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleRequestDTO {
    @NotNull(message = "date work cannot be null")
    private LocalDate dateWork;

    @NotNull(message = "start time cannot be null")
    private LocalTime startTime;

    @NotNull(message = "end time cannot be null")
    private LocalTime endTime;
}
