package by.it.academy.dodo.services.tentativeSchedule;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.entities.TentativeSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.TentativeScheduleMapper;
import by.it.academy.dodo.repositories.tentativeSchedule.TentativeScheduleRepository;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static by.it.academy.dodo.utils.Utility.getWeek;

@Service
@RequiredArgsConstructor
public class TentativeScheduleServiceImpl implements TentativeScheduleService {
    private final TentativeScheduleRepository tentativeScheduleRepository;
    private final WorkerRepository workerRepository;
    private final TentativeScheduleMapper tentativeScheduleMapper;
    /**
     * Creates a new tentative schedule for the specified worker.
     *
     * @param idWorker             The ID of the worker.
     * @param tentativeScheduleDTO The tentative schedule data to create.
     * @return {@code true} if the tentative schedule is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the tentative schedule data is invalid.
     */
    @Transactional
    @Override
    public boolean createTentativeSchedule(UUID idWorker, TentativeScheduleDto tentativeScheduleDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (tentativeScheduleDTO != null) {
            TentativeSchedule tentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(tentativeScheduleDTO);

            tentativeSchedule.setWorker(workerRepository.findById(idWorker)
                    .orElseThrow(() -> new ClientInvalidDataException("Worker was not found")));
            return saveTentativeSchedule(tentativeSchedule);
        }
        throw new ClientInvalidDataException("Unable to create tentative schedule");
    }
    /**
     * Saves the provided tentative schedule to the repository.
     *
     * @param tentativeSchedule The tentative schedule to save.
     * @return {@code true} if the tentative schedule is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the tentative schedule data is invalid.
     */
    @Override
    @Transactional
    public boolean saveTentativeSchedule(TentativeSchedule tentativeSchedule) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (tentativeSchedule != null) {
            try {
                tentativeScheduleRepository.saveAndFlush(tentativeSchedule);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save tentative schedule");
            }
        }
        throw new ClientInvalidDataException("Unable to save tentative schedule");
    }
    /**
     * Updates the tentative schedule with the specified ID using the provided {@link TentativeScheduleDto}.
     *
     * @param id                   The ID of the tentative schedule to update.
     * @param tentativeScheduleDTO The updated tentative schedule data.
     * @return {@code true} if the tentative schedule is updated successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the tentative schedule data is invalid.
     */
    @Transactional
    @Override
    public boolean updateTentativeSchedule(UUID id, TentativeScheduleDto tentativeScheduleDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if (tentativeScheduleDTO != null) {
            TentativeSchedule newTentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(tentativeScheduleDTO);
            Optional<TentativeSchedule> optionalTentativeSchedule = tentativeScheduleRepository.findById(id);

            if (optionalTentativeSchedule.isPresent()) {
                TentativeSchedule oldTentativeSchedule = optionalTentativeSchedule.get();
                setSchedule(newTentativeSchedule.getStartTime(), newTentativeSchedule.getEndTime(), oldTentativeSchedule);
                return saveTentativeSchedule(oldTentativeSchedule);
            }
            throw new ClientInvalidDataException("Tentative schedule was not found");
        }
        throw new ClientInvalidDataException("Unable to update tentative schedule");
    }
    /**
     * Sets up the updating of the tentative schedule with new schedule data.
     *
     * @param startTime          The new start time.
     * @param endTime            The new end time.
     * @param tentativeSchedule The existing tentative schedule data.
     */
    private void setSchedule(LocalTime startTime, LocalTime endTime, TentativeSchedule tentativeSchedule) {
        tentativeSchedule.setStartTime(startTime);
        tentativeSchedule.setEndTime(endTime);
    }
    /**
     * Retrieves the tentative schedule for the specified worker for the given week.
     *
     * @param idWorker The ID of the worker.
     * @param date     The date within the week for which the tentative schedule is requested.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDto> getWeekTentativeSchedule(UUID idWorker, LocalDate date) throws ClientInvalidDataException {
        LocalDate[] week = getWeek(date);

        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByWorkerIdAndDateWorkBetween(idWorker, week[0], week[1]).orElse(Collections.emptyList());

        return getTentativeScheduleDTOS(tentativeSchedules);
    }
    /**
     * Retrieves the tentative schedule for the specified date.
     *
     * @param date The date for which the tentative schedule is requested.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDto> getDayTentativeSchedule(LocalDate date) throws ClientInvalidDataException {
        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByDateWork(date).orElse(Collections.emptyList());

        return getTentativeScheduleDTOS(tentativeSchedules);
    }
    /**
     * Helper method to map a list of tentative schedules to a list of tentative schedule DTOs.
     *
     * @param tentativeSchedules The list of tentative schedules to map.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    private List<TentativeScheduleDto> getTentativeScheduleDTOS(List<TentativeSchedule> tentativeSchedules) throws ClientInvalidDataException {
        if (tentativeSchedules != null) {
            if (tentativeSchedules.isEmpty()) {
                throw new ClientInvalidDataException("Tentative schedule was not found");
            }
            return tentativeScheduleMapper.createTentativeScheduleDTOList(tentativeSchedules);
        }
        throw new ClientInvalidDataException("Unable to get tentative schedule");
    }
    /**
     * Deletes the tentative schedule with the specified ID.
     *
     * @param id The ID of the tentative schedule to delete.
     * @return {@code true} if the tentative schedule is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    @Transactional
    @Override
    public boolean deleteTentativeSchedule(UUID id) throws ClientInvalidDataException {
        TentativeSchedule tentativeSchedule = tentativeScheduleRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Tentative schedule was not found"));

        tentativeScheduleRepository.delete(tentativeSchedule);
        return true;
    }
}
