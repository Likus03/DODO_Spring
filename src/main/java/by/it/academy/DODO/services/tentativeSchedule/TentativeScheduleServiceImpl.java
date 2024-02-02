package by.it.academy.DODO.services.tentativeSchedule;

import by.it.academy.DODO.entities.TentativeSchedule;
import by.it.academy.DODO.entities.Worker;
import by.it.academy.DODO.repositories.tentativeSchedule.TentativeScheduleRepository;
import by.it.academy.DODO.repositories.worker.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static by.it.academy.DODO.utils.Utility.getWeek;

@Service
@RequiredArgsConstructor
public class TentativeScheduleServiceImpl implements TentativeScheduleService {
    private final TentativeScheduleRepository tentativeScheduleRepository;
    private final WorkerRepository workerRepository;

    @Transactional
    @Override
    public boolean addTentativeSchedule(UUID idWorker, LocalDate dateWork, LocalTime startTime, LocalTime endTime) {
        Optional<TentativeSchedule> optionalTentativeSchedule = tentativeScheduleRepository.findByIdAndDateWork(idWorker, dateWork);
        if (optionalTentativeSchedule.isPresent()) {
            TentativeSchedule tentativeSchedule = optionalTentativeSchedule.get();
            setSchedule(startTime, endTime, tentativeSchedule);
            tentativeScheduleRepository.save(tentativeSchedule);
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
    public List<TentativeSchedule> readTentativeScheduleById(UUID idWorker, LocalDate date) {
        LocalDate[] week = getWeek(date);
        return tentativeScheduleRepository.findAllByIdAndDateWorkBetween(idWorker, week[0], week[1]).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public LocalDate getMaxDate(UUID idWorker) {
//        return tentativeScheduleRepository.findByDateWorkMax(idWorker).orElse(null);
        return null;
    }

    @Transactional
    @Override
    public boolean AddEmptySchedule(UUID idWorker, LocalDate now) {
        Optional<Worker> optionalWorker = workerRepository.findById(idWorker);

        if(optionalWorker.isPresent()) {
            Worker worker = optionalWorker.get();
            LocalDate[] week = getWeek(now);

            while (!week[0].isAfter(week[1])){
                TentativeSchedule tentativeSchedule = new TentativeSchedule(week[0], worker);
                tentativeScheduleRepository.save(tentativeSchedule);

                week[0] = week[0].plusDays(1);
            }
            return true;
        }
        return false;
    }
}
