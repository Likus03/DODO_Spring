package by.it.academy.dodo.dto.request.workSchedule;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Data Transfer Object (DTO) for receiving work schedule-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleRequestDto {

    /**
     * The date of the work schedule.
     */
    @NotNull(message = "Date work cannot be null")
    private LocalDate workDate;

    /**
     * The start time of the work schedule.
     */
    @NotNull(message = "Start time cannot be null")
    private LocalTime startTime;

    /**
     * The end time of the work schedule.
     */
    @NotNull(message = "End time cannot be null")
    private LocalTime endTime;
}
