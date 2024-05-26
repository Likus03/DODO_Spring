package by.it.academy.dodo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clients")
public class Client {
    @Id
    private ObjectId id;

    private String firstname;

    private String phoneNumber;

    private String email;

    private LocalDate birthday;
}
