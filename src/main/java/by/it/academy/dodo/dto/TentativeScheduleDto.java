package by.it.academy.dodo.dto;

import by.it.academy.dodo.dto.response.worker.WorkerResponseScheduleDto;
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
public class TentativeScheduleDto {

    /**
     * The date of the tentative schedule.
     */
    @NotNull(message = "date work cannot be null")
    private LocalDate workDate;

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

    /**
     * Worker associated with the work schedule.
     */
//    private WorkerResponseScheduleDto worker;
}

