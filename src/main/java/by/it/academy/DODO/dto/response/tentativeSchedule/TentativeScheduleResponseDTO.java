package by.it.academy.DODO.dto.response.tentativeSchedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TentativeScheduleResponseDTO {
    private LocalDate dateWork;
    private LocalTime startTime;
    private LocalTime endTime;
}
