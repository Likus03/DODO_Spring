package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.request.order.OrderRequestDTO;
import by.it.academy.DODO.dto.response.order.OrderResponseDTO;
import by.it.academy.DODO.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponseDTO createOrderDTO(Order order);
    @Mapping(target = "completed", expression = "java(getDefaultValue())")
    Order createOder(OrderRequestDTO orderRequestDTO);

    default boolean getDefaultValue() {
        return false;
    }
}
