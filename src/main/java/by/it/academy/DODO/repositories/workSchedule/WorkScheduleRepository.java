package by.it.academy.DODO.repositories.workSchedule;

import by.it.academy.DODO.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, UUID> {
    Optional<List<WorkSchedule>> findAllByDateWork(LocalDate dateWork);
    Optional<List<WorkSchedule>> findAllByDateWorkBetween(LocalDate startWeek, LocalDate endWeek);
}
