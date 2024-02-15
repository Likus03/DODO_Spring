package by.it.academy.dodo.dto.response.workSchedule;

import by.it.academy.dodo.dto.response.worker.WorkerResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Data Transfer Object (DTO) for representing work schedule information in a response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleResponseDto {

    /**
     * Date of the work schedule.
     */
    private LocalDate dateWork;

    /**
     * Start time of the work schedule.
     */
    private LocalTime startTime;

    /**
     * End time of the work schedule.
     */
    private LocalTime endTime;

    /**
     * Worker associated with the work schedule.
     */
    private WorkerResponseDto worker;
}

