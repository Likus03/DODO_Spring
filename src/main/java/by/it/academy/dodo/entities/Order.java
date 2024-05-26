package by.it.academy.dodo.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Order {
    @Id
    private ObjectId id;

    private BigDecimal totalCost;

    private String address;

    private LocalDateTime deliveryTime;

    private Boolean isCompleted;

    @DBRef
    private Client client;

    @DBRef
    private Worker worker;

    @DBRef
    private List<Menu> menu;
}
