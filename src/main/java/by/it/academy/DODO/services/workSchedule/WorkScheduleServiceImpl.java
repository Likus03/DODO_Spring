package by.it.academy.DODO.services.workSchedule;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.entities.WorkSchedule;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.WorkScheduleMapper;
import by.it.academy.DODO.repositories.workSchedule.WorkScheduleRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    private final WorkerRepository workerRepository;
    private final WorkScheduleMapper workScheduleMapper;

    @Override
    @Transactional
    public boolean createWorkSchedule(UUID id, WorkScheduleRequestDTO workScheduleRequestDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        WorkSchedule workSchedule = workScheduleMapper.createWorkSchedule(workScheduleRequestDTO);
        Worker worker = workerRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Work schedule was not found"));
        workSchedule.setWorker(worker);

        return save(workSchedule);
    }

    @Override
    @Transactional
    public boolean save(WorkSchedule workSchedule) throws DataIntegrityViolationException {
        try {
            workScheduleRepository.save(workSchedule);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save work schedule");
        }
    }

    private List<WorkScheduleResponseDTO> getWorkScheduleResponseDTOS(List<WorkSchedule> workSchedules) throws ClientInvalidDataException{
        if (workSchedules.isEmpty()) {
            throw new ClientInvalidDataException("Work schedule does not exist");
        }
        return workSchedules.stream()
                .map(workScheduleMapper::createWorkScheduleDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDTO> getDayWorkSchedule(LocalDate dateWork) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByDateWork(dateWork).orElse(Collections.emptyList());

        return getWorkScheduleResponseDTOS(workSchedules);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkScheduleResponseDTO> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork) throws ClientInvalidDataException {
        List<WorkSchedule> workSchedules = workScheduleRepository
                .findAllByDateWorkBetween(startWork, endWork).orElse(Collections.emptyList());

        return getWorkScheduleResponseDTOS(workSchedules);
    }

    @Override
    @Transactional
    public boolean deleteWorkSchedule(UUID id) throws ClientInvalidDataException{
        WorkSchedule workerSchedule = workScheduleRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Worker was not found"));

        workScheduleRepository.delete(workerSchedule);
        return true;
    }
}
