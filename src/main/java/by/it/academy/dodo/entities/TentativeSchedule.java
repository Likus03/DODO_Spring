package by.it.academy.dodo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TENTATIVE_SCHEDULES", uniqueConstraints = @UniqueConstraint(columnNames = {"WORK_DATE", "WORKER_ID"}))
public class TentativeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "WORK_DATE", nullable = false)
    private LocalDate workDate;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID", nullable = false)
    private Worker worker;

    public TentativeSchedule(LocalDate workDate, LocalTime startTime, LocalTime endTime) {
        this.workDate = workDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
