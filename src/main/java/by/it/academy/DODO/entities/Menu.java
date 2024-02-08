package by.it.academy.DODO.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MENUS")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NotEmpty(message = "Name cannot be null")
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotEmpty(message = "Describe cannot be null")
    @Column(name = "DESCRIBE", nullable = false)
    private String describe;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Cost cannot be negative")
    @Column(name = "COST", nullable = false)
    private Float cost;

    @ManyToMany(mappedBy = "menus")
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu menu)) return false;
        return Objects.equals(getId(), menu.getId()) && Objects.equals(getName(), menu.getName()) && Objects.equals(getDescribe(), menu.getDescribe()) && Objects.equals(getCost(), menu.getCost()) && Objects.equals(getOrders(), menu.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescribe(), getCost(), getOrders());
    }
}
