package by.it.academy.dodo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "TOTAL_COST")
    private Float totalCost;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "DELIVERY_TIME", nullable = false)
    private LocalDateTime deliveryTime;

    @Column(name = "COMPLETED", nullable = false)
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID")
    private Worker worker;

    @ManyToMany
    @JoinTable(name = "ORDER_DESCRIBES",
            joinColumns = @JoinColumn(name = "ORDER_ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "MENU_ID", nullable = false))
    private List<Menu> menus;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getTotalCost(), order.getTotalCost()) && Objects.equals(getAddress(), order.getAddress()) && Objects.equals(getDeliveryTime(), order.getDeliveryTime()) && Objects.equals(getCompleted(), order.getCompleted()) && Objects.equals(getClient(), order.getClient()) && Objects.equals(getWorker(), order.getWorker()) && Objects.equals(getMenus(), order.getMenus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTotalCost(), getAddress(), getDeliveryTime(), getCompleted(), getClient(), getWorker(), getMenus());
    }
}
