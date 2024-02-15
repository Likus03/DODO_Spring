package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.TentativeScheduleDTO;
import by.it.academy.DODO.entities.TentativeSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link TentativeScheduleDTO} and {@link TentativeSchedule}.
 */
@Component
@Mapper(componentModel = "spring")
public interface TentativeScheduleMapper {

    /**
     * Converts a {@link TentativeSchedule} entity to a {@link TentativeScheduleDTO}.
     *
     * @param tentativeSchedule The {@link TentativeSchedule} entity to convert.
     * @return The corresponding {@link TentativeScheduleDTO}.
     */
    TentativeScheduleDTO createTentativeScheduleDTO(TentativeSchedule tentativeSchedule);

    /**
     * Converts a {@link TentativeScheduleDTO} to a {@link TentativeSchedule}.
     *
     * @param tentativeScheduleDTO The {@link TentativeScheduleDTO} to convert.
     * @return The corresponding {@link TentativeSchedule} entity.
     */
    TentativeSchedule createTentativeSchedule(TentativeScheduleDTO tentativeScheduleDTO);

    /**
     * Converts a list of {@link TentativeSchedule} entity to a list of {@link TentativeScheduleDTO}.
     * @param tentativeSchedules The list of {@link TentativeSchedule} entity to convert.
     * @return The corresponding list of {@link TentativeScheduleDTO}.
     */
    List<TentativeScheduleDTO> createTentativeScheduleDTOList(List<TentativeSchedule> tentativeSchedules);
}
