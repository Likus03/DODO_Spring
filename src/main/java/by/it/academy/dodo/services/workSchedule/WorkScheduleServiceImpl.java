package by.it.academy.dodo.services.workSchedule;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.entities.WorkSchedule;
import by.it.academy.dodo.entities.Worker;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.WorkScheduleMapper;
import by.it.academy.dodo.repositories.workSchedule.WorkScheduleRepository;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    private final WorkerRepository workerRepository;
    private final WorkScheduleMapper workScheduleMapper;
    /**
     * Creates a new work schedule for the specified worker.
     *
     * @param idWorker               The ID of the worker.
     * @param workScheduleRequestDTO The request DTO containing the work schedule details.
     * @return {@code true} if the work schedule is created successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the work schedule data is invalid or not found.
     */
    @Override
    @Transactional
    public boolean createWorkSchedule(UUID idWorker, WorkScheduleRequestDto workScheduleRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        if(workScheduleRequestDTO!=null) {

            WorkSchedule workSchedule = workScheduleMapper.createWorkSchedule(workScheduleRequestDTO);
            Worker worker = workerRepository.findById(idWorker)
                    .orElseThrow(() -> new ClientInvalidDataException("Work schedule was not found"));
            workSchedule.setWorker(worker);

            return saveWorkSchedule(workSchedule);
        }
        throw new ClientInvalidDataException("Unable to create work schedule");
    }
    /**
     * Saves the provided work schedule to the repository.
     *
     * @param workSchedule The work schedule to save.
     * @return {@code true} if the work schedule is saved successfully, {@code false} otherwise.
     * @throws DataIntegrityViolationException If there is a data integrity violation.
     * @throws ClientInvalidDataException      If the work schedule data is invalid.
     */
    @Override
    @Transactional
    public boolean saveWorkSchedule(WorkSchedule workSchedule) throws DataIntegrityViolationException {
        if(workSchedule != null) {
            try {
                workScheduleRepository.saveAndFlush(workSchedule);
                return true;
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Unable to save work schedule");
            }
        }
        throw new ClientInvalidDataException("Unable to save work schedule");

    }
    /**
     * Helper method to map a list of tentative schedules to a list of tentative schedule DTOs.
     *
     * @param workSchedules The list of work schedules to map.
     * @return A list of work schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    private List<WorkScheduleResponseDto> getWorkScheduleResponseDTOS(List<WorkSchedule> workSchedules) throws ClientInvalidDataException {
        if (workSchedules != null) {
            if (workSchedules.isEmpty()) {
                throw new ClientInvalidDataException("Work schedule does not exist");
            }
            return workScheduleMapper.createWorkScheduleDTOList(workSchedules);
        }
        throw new ClientInvalidDataException("Unable to get work schedule");
    }
    /**
     * Retrieves a list of work schedules for the specified date.
     *
     * @param dateWork The date for which to retrieve work schedules.
     * @return A list of {@link WorkScheduleResponseDto}.
     * @throws ClientInvalidDataException If the work schedule data is invalid or not found.
     */

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDto> getDayWorkSchedule(LocalDate dateWork) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByDateWork(dateWork).orElse(Collections.emptyList());

        return getWorkScheduleResponseDTOS(workSchedules);
    }
    /**
     * Retrieves a list of work schedules for the specified date range.
     *
     * @param startWork The start date of the date range.
     * @param endWork   The end date of the date range.
     * @return A list of {@link WorkScheduleResponseDto}.
     * @throws ClientInvalidDataException If the work schedule data is invalid or not found.
     */
    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDto> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByDateWorkBetween(startWork, endWork).orElse(Collections.emptyList());

        return getWorkScheduleResponseDTOS(workSchedules);
    }
    /**
     * Deletes the work schedule with the specified ID.
     *
     * @param id The ID of the work schedule to delete.
     * @return {@code true} if the work schedule is deleted successfully, {@code false} otherwise.
     * @throws ClientInvalidDataException If the work schedule with the specified ID is not found.
     */
    @Override
    @Transactional
    public boolean deleteWorkSchedule(UUID id) throws ClientInvalidDataException{
        WorkSchedule workerSchedule = workScheduleRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Worker was not found"));

        workScheduleRepository.delete(workerSchedule);
        return true;
    }
}
