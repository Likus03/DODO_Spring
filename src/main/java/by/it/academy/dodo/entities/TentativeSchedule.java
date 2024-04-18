package by.it.academy.dodo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "TentativeSchedules")
@CompoundIndex(def = "{'workDate': 1, 'workerId': 1}", unique = true)
public class TentativeSchedule {
    @Id
    private ObjectId id;
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private Worker worker;

    public TentativeSchedule(LocalDate workDate, LocalTime startTime, LocalTime endTime) {
        this.workDate = workDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
