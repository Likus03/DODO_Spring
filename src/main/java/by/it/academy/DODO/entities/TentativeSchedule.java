package by.it.academy.DODO.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TENTATIVE_SCHEDULES", uniqueConstraints = @UniqueConstraint(columnNames = {"DATE_WORK", "WORKER_ID"}))
public class TentativeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DATE_WORK", nullable = false)
    private LocalDate dateWork;

    @Column(name = "START_TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID", nullable = false)
    private Worker worker;

    public TentativeSchedule(LocalDate dateWork, LocalTime startTime, LocalTime endTime) {
        this.dateWork = dateWork;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TentativeSchedule that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateWork(), that.getDateWork()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getWorker(), that.getWorker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateWork(), getStartTime(), getEndTime(), getWorker());
    }
}
