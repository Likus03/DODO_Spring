package by.it.academy.dodo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "tentativeSchedules")
public class TentativeSchedule {
    @Id
    private ObjectId id;
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @DBRef
    private Worker worker;
}
