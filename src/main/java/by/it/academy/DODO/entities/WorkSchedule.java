package by.it.academy.DODO.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "WORK_SCHEDULES", uniqueConstraints = @UniqueConstraint(columnNames = {"DATE_WORK", "WORKER_ID"}))
public class WorkSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "DATE_WORK", nullable = false)
    private LocalDate dateWork;

    @Column(name = "START_TIME", nullable = false)
    private LocalTime startTime;

    @Column(name = "END_TIME", nullable = false)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "WORKER_ID", nullable = false)
    private Worker worker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkSchedule that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateWork(), that.getDateWork()) && Objects.equals(getStartTime(), that.getStartTime()) && Objects.equals(getEndTime(), that.getEndTime()) && Objects.equals(getWorker(), that.getWorker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateWork(), getStartTime(), getEndTime(), getWorker());
    }
}
