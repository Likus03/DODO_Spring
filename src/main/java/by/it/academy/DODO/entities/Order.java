package by.it.academy.DODO.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DESCRIBE", nullable = false)
    private String describe;

    @Column(name = "COST", nullable = false)
    private Float cost;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "DELIVERY_TIME", nullable = false)
    private LocalDateTime deliveryTime;

    @Column(name = "COMPLETED", nullable = false)
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID")
    private Worker worker;

    public Order(String describe, Float cost, String address, LocalDateTime deliveryTime, Boolean completed, Worker worker) {
        this.describe = describe;
        this.cost = cost;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.completed = completed;
        this.worker = worker;
    }

    public Order(String describe) {
        this.describe = describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getDescribe(), order.getDescribe()) && Objects.equals(getCost(), order.getCost()) && Objects.equals(getAddress(), order.getAddress()) && Objects.equals(getDeliveryTime(), order.getDeliveryTime()) && Objects.equals(getCompleted(), order.getCompleted()) && Objects.equals(getWorker(), order.getWorker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescribe(), getCost(), getAddress(), getDeliveryTime(), getCompleted(), getWorker());
    }
}
