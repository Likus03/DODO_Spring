package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import by.it.academy.DODO.exceptions.EmptyObjectException;
import by.it.academy.DODO.mappers.TentativeScheduleMapper;
import by.it.academy.DODO.repositories.tentativeSchedule.TentativeScheduleRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
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
    public boolean create(UUID idWorker, TentativeScheduleDTO request) {
        TentativeSchedule tentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(request);

        tentativeSchedule.setWorker(workerRepository.findById(idWorker).orElseThrow());
        tentativeScheduleRepository.save(tentativeSchedule);
        return true;
    }

    @Transactional
    @Override
    public boolean update(UUID id, TentativeScheduleDTO request) {
        TentativeSchedule newTentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(request);
        Optional<TentativeSchedule> optionalTentativeSchedule = tentativeScheduleRepository.findById(id);

        if (optionalTentativeSchedule.isPresent()) {
            TentativeSchedule oldTentativeSchedule = optionalTentativeSchedule.get();
            setSchedule(newTentativeSchedule.getStartTime(), newTentativeSchedule.getEndTime(), oldTentativeSchedule);
            tentativeScheduleRepository.save(oldTentativeSchedule);
            return true;
        }
        return false;
    }

    private void setSchedule(LocalTime startTime, LocalTime endTime, TentativeSchedule tentativeSchedule) {
        tentativeSchedule.setStartTime(startTime);
        tentativeSchedule.setEndTime(endTime);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDTO> readWeekScheduleByIdWorker(UUID idWorker, LocalDate date) throws EmptyObjectException {
        LocalDate[] week = getWeek(date);

        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByWorkerIdAndDateWorkBetween(idWorker, week[0], week[1]).orElseThrow(() -> new NoSuchElementException(idWorker + " " + date));

        if (tentativeSchedules.isEmpty()) {
            throw new EmptyObjectException(idWorker + " " + date);
        }
        return tentativeSchedules.stream()
                .map(tentativeScheduleMapper::createTentativeScheduleDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TentativeScheduleDTO> readDaySchedule(LocalDate date) throws EmptyObjectException{
        List<TentativeSchedule> tentativeSchedules = tentativeScheduleRepository
                .findAllByDateWork(date).orElseThrow(() -> new NoSuchElementException(date.toString()));

        if (tentativeSchedules.isEmpty()) {
            throw new EmptyObjectException(date.toString());
        }
        return tentativeSchedules.stream()
                .map(tentativeScheduleMapper::createTentativeScheduleDTO)
                .toList();
    }

    @Override
    public boolean delete(UUID id) {
        try {
            tentativeScheduleRepository.deleteById(id);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(TentativeScheduleDTO tentativeScheduleDTO) {
        TentativeSchedule tentativeSchedule = tentativeScheduleMapper.createTentativeSchedule(tentativeScheduleDTO);
        try {
            tentativeScheduleRepository.save(tentativeSchedule);
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
