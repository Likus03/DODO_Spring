package by.it.academy.dodo.entities;

import by.it.academy.dodo.enums.WorkerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "workers")
public class Worker {
    @Id
    private ObjectId id;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private WorkerType workerType;

    public Worker(String firstname, String surname, String phoneNumber, WorkerType workerType) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.workerType = workerType;
    }
}
