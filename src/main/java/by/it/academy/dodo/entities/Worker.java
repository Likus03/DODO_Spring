package by.it.academy.dodo.entities;

import by.it.academy.dodo.enums.WorkerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<WorkSchedule> workSchedules;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<TentativeSchedule> tentativeSchedules;

    public Worker(String firstname, String surname, String phoneNumber, WorkerType workerType) {
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.workerType = workerType;
    }
}
