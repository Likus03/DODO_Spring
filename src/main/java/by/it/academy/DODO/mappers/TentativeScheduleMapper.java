package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TentativeScheduleMapper {
    TentativeScheduleDTO createTentativeScheduleDTO(TentativeSchedule tentativeSchedule);
    TentativeSchedule createTentativeSchedule(TentativeScheduleDTO request);

}
