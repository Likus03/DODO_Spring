package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.TentativeScheduleDto;
import by.it.academy.dodo.entities.TentativeSchedule;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Mapper interface for converting between {@link TentativeScheduleDto} and {@link TentativeSchedule}.
 */
@Component
@Mapper(componentModel = "spring")
public interface TentativeScheduleMapper {

    /**
     * Converts a {@link TentativeSchedule} entity to a {@link TentativeScheduleDto}.
     *
     * @param tentativeSchedule The {@link TentativeSchedule} entity to convert.
     * @return The corresponding {@link TentativeScheduleDto}.
     */
    TentativeScheduleDto createTentativeScheduleDTO(TentativeSchedule tentativeSchedule);

    /**
     * Converts a {@link TentativeScheduleDto} to a {@link TentativeSchedule}.
     *
     * @param tentativeScheduleDTO The {@link TentativeScheduleDto} to convert.
     * @return The corresponding {@link TentativeSchedule} entity.
     */
    TentativeSchedule createTentativeSchedule(TentativeScheduleDto tentativeScheduleDTO);

    /**
     * Converts a list of {@link TentativeSchedule} entity to a list of {@link TentativeScheduleDto}.
     * @param tentativeSchedules The list of {@link TentativeSchedule} entity to convert.
     * @return The corresponding list of {@link TentativeScheduleDto}.
     */
    List<TentativeScheduleDto> createTentativeScheduleDTOList(List<TentativeSchedule> tentativeSchedules);
}
