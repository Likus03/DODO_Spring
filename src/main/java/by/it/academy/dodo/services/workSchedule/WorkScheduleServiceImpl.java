package by.it.academy.dodo.services.workSchedule;

import by.it.academy.dodo.dto.request.workSchedule.WorkScheduleRequestDto;
import by.it.academy.dodo.dto.response.workSchedule.WorkScheduleResponseDto;
import by.it.academy.dodo.entities.WorkSchedule;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import by.it.academy.dodo.mappers.WorkScheduleMapper;
import by.it.academy.dodo.repositories.workSchedule.WorkScheduleRepository;
import by.it.academy.dodo.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    private final WorkerRepository workerRepository;
    private final WorkScheduleMapper workScheduleMapper;

    @Override
    @Transactional
    public boolean createWorkSchedule(UUID workerId, WorkScheduleRequestDto workScheduleRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        WorkSchedule workSchedule = workScheduleMapper.mapToWorkSchedule(workScheduleRequestDTO);

        workSchedule.setWorker(workerRepository.findById(workerId)
                .orElseThrow(() -> new ClientInvalidDataException("Work schedule was not found")));
        return saveWorkSchedule(workSchedule);
    }

    @Override
    @Transactional
    public boolean saveWorkSchedule(WorkSchedule workSchedule) throws DataIntegrityViolationException {
        try {
            workScheduleRepository.saveAndFlush(workSchedule);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save work schedule");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDto> getDayWorkSchedule(LocalDate workDate) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByWorkDate(workDate);

        return getWorkScheduleResponseDto(workSchedules);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDto> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByWorkDateBetween(startWork, endWork);

        return getWorkScheduleResponseDto(workSchedules);
    }

    @Override
    @Transactional
    public boolean deleteWorkSchedule(UUID id){
        return workScheduleRepository.deleteWorkSchedule(id);
    }

    /**
     * Helper method to map a list of tentative schedules to a list of tentative schedule DTOs.
     *
     * @param workSchedules The list of work schedules to map.
     * @return A list of work schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    private List<WorkScheduleResponseDto> getWorkScheduleResponseDto(List<WorkSchedule> workSchedules) throws ClientInvalidDataException {
        if (workSchedules.isEmpty()) {
            throw new ClientInvalidDataException("Work schedule does not exist");
        }
        return workScheduleMapper.mapToWorkScheduleDtoList(workSchedules);
    }

}
