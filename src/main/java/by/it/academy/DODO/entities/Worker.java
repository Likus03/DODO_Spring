package by.it.academy.DODO.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import by.it.academy.DODO.WorkerType;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WORKERS")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "WORKER_TYPE", nullable = false)
    @Enumerated(STRING)
    private WorkerType workerType;

    @OneToOne(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkSchedule> workSchedules;

    public Worker(String firstname, String surname, String phoneNumber, WorkerType workerType, List<Order> orders) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.workerType = workerType;
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(getId(), worker.getId()) && Objects.equals(getFirstname(), worker.getFirstname()) && Objects.equals(getSurname(), worker.getSurname()) && Objects.equals(getPhoneNumber(), worker.getPhoneNumber()) && getWorkerType() == worker.getWorkerType() && Objects.equals(getUser(), worker.getUser()) && Objects.equals(getOrders(), worker.getOrders()) && Objects.equals(getWorkSchedules(), worker.getWorkSchedules());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getSurname(), getPhoneNumber(), getWorkerType(), getUser(), getOrders(), getWorkSchedules());
    }
}
