package by.it.academy.DODO.repositories.workSchedule;

import by.it.academy.DODO.entities.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, UUID> {
}
