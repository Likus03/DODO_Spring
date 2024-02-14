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
/**
 * Repository interface for performing CRUD operations on {@link Worker} entities.
 */
public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    /**
     * Finds workers based on a search parameter that may match fields like firstname, phone_number, surname, and worker_type.
     *
     * @param parameter The search parameter to match against worker fields.
     * @return An optional list of {@link Worker} containing matching the search parameter.
     */
    @NonNull
    @Query(value = "select * from workers where firstname||phone_number||surname||worker_type ilike %:param%", nativeQuery = true)
    Optional<List<Worker>> findByParameter(@Nullable @Param("param") String parameter);
}
