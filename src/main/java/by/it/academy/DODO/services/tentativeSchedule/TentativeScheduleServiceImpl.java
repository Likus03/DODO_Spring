package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import by.it.academy.DODO.mappers.TentativeScheduleMapper;
import by.it.academy.DODO.repositories.tentativeSchedule.TentativeScheduleRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
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

import static by.it.academy.DODO.utils.Utility.getWeek;

@Service
@RequiredArgsConstructor
public class TentativeScheduleServiceImpl implements TentativeScheduleService {
    private final TentativeScheduleRepository tentativeScheduleRepository;
    private final WorkerRepository workerRepository;
    private final TentativeScheduleMapper tentativeScheduleMapper;

    @Transactional
    @Override
    public boolean create(UUID idWorker, TentativeScheduleDTO request) throws DataIntegrityViolationException {
        TentativeSchedule tentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(request);

        tentativeSchedule.setWorker(workerRepository.findById(idWorker).orElseThrow());
        return save(tentativeSchedule);
    }

    private boolean save(TentativeSchedule tentativeSchedule) throws DataIntegrityViolationException {
        try {
            tentativeScheduleRepository.saveAndFlush(tentativeSchedule);
            return true;
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Unable to save tentative schedule");
        }
    }

    @Transactional
    @Override
    public boolean update(UUID id, TentativeScheduleDTO request) throws DataIntegrityViolationException, ClientInvalidDataException {
        TentativeSchedule newTentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(request);
        Optional<TentativeSchedule> optionalTentativeSchedule = tentativeScheduleRepository.findById(id);

        if (optionalTentativeSchedule.isPresent()) {
            TentativeSchedule oldTentativeSchedule = optionalTentativeSchedule.get();
            setSchedule(newTentativeSchedule.getStartTime(), newTentativeSchedule.getEndTime(), oldTentativeSchedule);
            return save(oldTentativeSchedule);
        }
        throw new ClientInvalidDataException("Tentative schedule was not found");
    }

    private void setSchedule(LocalTime startTime, LocalTime endTime, TentativeSchedule tentativeSchedule) {
        tentativeSchedule.setStartTime(startTime);
        tentativeSchedule.setEndTime(endTime);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDTO> getWeekScheduleByIdWorker(UUID idWorker, LocalDate date) throws ClientInvalidDataException {
        LocalDate[] week = getWeek(date);

        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByWorkerIdAndDateWorkBetween(idWorker, week[0], week[1]).orElse(Collections.emptyList());

        if (tentativeSchedules.isEmpty()) {
            throw new ClientInvalidDataException("Tentative schedule was not found");
        }
        return tentativeSchedules.stream()
                .map(tentativeScheduleMapper::createTentativeScheduleDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDTO> getDaySchedule(LocalDate date) throws ClientInvalidDataException {
        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByDateWork(date).orElse(Collections.emptyList());

        if (tentativeSchedules.isEmpty()) {
            throw new ClientInvalidDataException("Tentative schedule was not found");
        }
        return tentativeSchedules.stream()
                .map(tentativeScheduleMapper::createTentativeScheduleDTO)
                .toList();
    }

    @Transactional
    @Override
    public boolean delete(UUID id) throws ClientInvalidDataException{
        TentativeSchedule tentativeSchedule = tentativeScheduleRepository.findById(id)
                .orElseThrow(() -> new ClientInvalidDataException("Tentative schedule was not found"));

        tentativeScheduleRepository.delete(tentativeSchedule);
        return true;
    }
}
