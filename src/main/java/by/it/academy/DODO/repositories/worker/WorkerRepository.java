package by.it.academy.DODO.repositories.worker;

import by.it.academy.DODO.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    @NonNull
    @Query(value = "select * from workers where firstname||phonenumber||surname||workertype ilike '%:param%'", nativeQuery = true)
    Optional<List<Worker>> findByParameter(@Nullable @Param("param") String parameter);
}
