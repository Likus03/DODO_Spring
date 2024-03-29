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
import java.util.List;
import java.util.UUID;

import static by.it.academy.dodo.utils.Utility.getWeek;

@Service
@RequiredArgsConstructor
public class TentativeScheduleServiceImpl implements TentativeScheduleService {
    private final TentativeScheduleRepository tentativeScheduleRepository;
    private final WorkerRepository workerRepository;
    private final TentativeScheduleMapper tentativeScheduleMapper;

    @Transactional
    @Override
    public boolean createTentativeSchedule(UUID workerId, TentativeScheduleDto tentativeScheduleDTO) throws DataIntegrityViolationException, ClientInvalidDataException {
        TentativeSchedule tentativeSchedule = tentativeScheduleMapper.mapToTentativeSchedule(tentativeScheduleDTO);

        tentativeSchedule.setWorker(workerRepository.findById(workerId)
                .orElseThrow(() -> new ClientInvalidDataException("Worker was not found")));
        return saveTentativeSchedule(tentativeSchedule);
    }

    @Override
    @Transactional
    public boolean saveTentativeSchedule(TentativeSchedule tentativeSchedule) throws DataIntegrityViolationException {
        try {
            tentativeScheduleRepository.saveAndFlush(tentativeSchedule);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save tentative schedule");
        }
    }

    @Transactional
    @Override
    public boolean updateTentativeSchedule(UUID id, TentativeScheduleDto tentativeScheduleDTO) {
        TentativeSchedule newTentativeSchedule = tentativeScheduleMapper.mapToTentativeSchedule(tentativeScheduleDTO);
        return tentativeScheduleRepository.updateTentativeSchedule(id, newTentativeSchedule);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDto> getWeekTentativeSchedule(UUID workerId, LocalDate date) throws ClientInvalidDataException {
        LocalDate[] week = getWeek(date);

        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByWorkerIdAndWorkDateBetween(workerId, week[0], week[1]);

        return getTentativeScheduleDTOS(tentativeSchedules);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDto> getDayTentativeSchedule(LocalDate date) throws ClientInvalidDataException {
        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByWorkDate(date);

        return getTentativeScheduleDTOS(tentativeSchedules);
    }

    @Transactional
    @Override
    public boolean deleteTentativeSchedule(UUID id) {
        return tentativeScheduleRepository.deleteTentativeSchedule(id);
    }

    /**
     * Helper method to map a list of tentative schedules to a list of tentative schedule DTOs.
     *
     * @param tentativeSchedules The list of tentative schedules to map.
     * @return A list of tentative schedule DTOs.
     * @throws ClientInvalidDataException If the tentative schedule data is invalid.
     */
    private List<TentativeScheduleDto> getTentativeScheduleDTOS(List<TentativeSchedule> tentativeSchedules) throws ClientInvalidDataException {
        if (tentativeSchedules.isEmpty()) {
            throw new ClientInvalidDataException("Tentative schedule was not found");
        }
        return tentativeScheduleMapper.mapToTentativeScheduleDtoList(tentativeSchedules);
    }
}
