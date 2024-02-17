package by.it.academy.dodo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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

    @Setter(AccessLevel.NONE)
    @Column(name = "TOTAL_COST")
    private BigDecimal totalCost;

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
}
