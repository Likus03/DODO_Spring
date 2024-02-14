package by.it.academy.DODO.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Data Transfer Object (DTO) for representing tentative schedule information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TentativeScheduleDTO {

    /**
     * The date of the tentative schedule.
     */
    @NotNull(message = "date work cannot be null")
    private LocalDate dateWork;

    /**
     * The start time of the tentative schedule.
     */
    @NotNull(message = "start time cannot be null")
    private LocalTime startTime;

    /**
     * The end time of the tentative schedule.
     */
    @NotNull(message = "end time cannot be null")
    private LocalTime endTime;
}

