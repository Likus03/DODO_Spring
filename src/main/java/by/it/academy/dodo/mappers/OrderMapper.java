package by.it.academy.dodo.mappers;

import by.it.academy.dodo.dto.request.order.OrderRequestDto;
import by.it.academy.dodo.dto.response.order.OrderResponseDto;
import by.it.academy.dodo.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link OrderRequestDto}, {@link OrderResponseDto}, and {@link Order}.
 */
@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {

    /**
     * Converts an {@link Order} entity to an {@link OrderResponseDto}.
     *
     * @param order The {@link Order} entity to convert.
     * @return The corresponding {@link OrderResponseDto}.
     */
    OrderResponseDto createOrderDTO(Order order);

    /**
     * Converts an {@link OrderRequestDto} to an {@link Order}.
     *
     * @param orderRequestDTO The {@link OrderRequestDto} to convert.
     * @return The corresponding {@link Order} entity.
     */
    @Mapping(target = "completed", expression = "java(getDefaultValue())")
    Order createOder(OrderRequestDto orderRequestDTO);

    /**
     * Provides a default value for the 'completed' field.
     *
     * @return The default value for 'completed'.
     */
    default boolean getDefaultValue() {
        return false;
    }

    /**
     * Converts a list of {@link Order} entity to a list of {@link OrderResponseDto}.
     * @param orders The list of {@link Order} entity to convert.
     * @return The corresponding list of {@link OrderResponseDto}.
     */
    List<OrderResponseDto> createOrderDTOList(List<Order> orders);
}
