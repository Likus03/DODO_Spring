package by.it.academy.DODO.repositories.tentativeSchedule;

import by.it.academy.DODO.entities.TentativeSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TentativeScheduleRepository extends JpaRepository<TentativeSchedule, UUID> {
    @NonNull
    Optional<TentativeSchedule> findByIdAndDateWork(@NonNull UUID id, @NonNull LocalDate dateWork);

    @NonNull
    Optional<List<TentativeSchedule>> findAllByIdAndDateWorkBetween(@NonNull UUID id, @NonNull LocalDate dateStartWeek, @NonNull LocalDate dateEndWeek);

    @NonNull
    Optional<LocalDate> findByDateWorkMax(@NonNull UUID id);
}
