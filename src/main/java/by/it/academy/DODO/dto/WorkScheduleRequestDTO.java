package by.it.academy.DODO.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleRequestDTO {
    private LocalDate dateWork;
    private LocalTime startTime;
    private LocalTime endTime;
    private UUID idWorker;
}
