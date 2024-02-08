package by.it.academy.DODO.services.workSchedule;

import by.it.academy.DODO.dto.request.workSchedule.WorkScheduleRequestDTO;
import by.it.academy.DODO.dto.response.workSchedule.WorkScheduleResponseDTO;
import by.it.academy.DODO.entities.WorkSchedule;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.mappers.WorkScheduleMapper;
import by.it.academy.DODO.repositories.workSchedule.WorkScheduleRepository;
import by.it.academy.DODO.services.worker.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    private final WorkerService workerService;
    private final WorkScheduleMapper workScheduleMapper;

    @Override
    public boolean createWorkSchedule(WorkScheduleRequestDTO workScheduleRequestDTO) throws DataIntegrityViolationException/*нарушение unique*/ {
        WorkSchedule workSchedule = workScheduleMapper.createWorkSchedule(workScheduleRequestDTO);
        Worker worker = workerService.findById(workScheduleRequestDTO.getIdWorker());
        workSchedule.setWorker(worker);
        try {
            workScheduleRepository.save(workSchedule);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<WorkScheduleResponseDTO> getDayWorkSchedule(LocalDate dateWork) {
        return workScheduleRepository.findAllByDateWork(dateWork)
                .map(schedules -> schedules.stream()
                        .map(workSchedule -> {
                            WorkScheduleResponseDTO workScheduleResponseDTO = workScheduleMapper.createWorkScheduleDTO(workSchedule);
                            workScheduleResponseDTO.setFirstname(workSchedule.getWorker().getFirstname());
                            workScheduleResponseDTO.setSurname(workSchedule.getWorker().getSurname());
                            return workScheduleResponseDTO;
                        })
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<WorkScheduleResponseDTO> getWeekWorkSchedule(LocalDate startWork, LocalDate endWork) {
        return workScheduleRepository.findAllByDateWorkBetween(startWork, endWork)
                .map(schedules -> schedules.stream()
                        .map(workSchedule -> {
                            WorkScheduleResponseDTO workScheduleResponseDTO = workScheduleMapper.createWorkScheduleDTO(workSchedule);
                            workScheduleResponseDTO.setFirstname(workSchedule.getWorker().getFirstname());
                            workScheduleResponseDTO.setSurname(workSchedule.getWorker().getSurname());
                            return workScheduleResponseDTO;
                        })
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    @Override
    public boolean deleteWorkSchedule(UUID id) {
        try {
            workScheduleRepository.deleteById(id);
        }
        catch (DataAccessException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
