package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper interface for converting between {@link OrderRequestDTO}, {@link OrderResponseDTO}, and {@link Order}.
 */
@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {

    /**
     * Converts an {@link Order} entity to an {@link OrderResponseDTO}.
     *
     * @param order The {@link Order} entity to convert.
     * @return The corresponding {@link OrderResponseDTO}.
     */
    OrderResponseDTO createOrderDTO(Order order);

    /**
     * Converts an {@link OrderRequestDTO} to an {@link Order}.
     *
     * @param orderRequestDTO The {@link OrderRequestDTO} to convert.
     * @return The corresponding {@link Order} entity.
     */
    @Mapping(target = "completed", expression = "java(getDefaultValue())")
    Order createOder(OrderRequestDTO orderRequestDTO);

    /**
     * Provides a default value for the 'completed' field.
     *
     * @return The default value for 'completed'.
     */
    default boolean getDefaultValue() {
        return false;
    }

    /**
     * Converts a list of {@link Order} entity to a list of {@link OrderResponseDTO}.
     * @param orders The list of {@link Order} entity to convert.
     * @return The corresponding list of {@link OrderResponseDTO}.
     */
    List<OrderResponseDTO> createOrderDTOList(List<Order> orders);
}
