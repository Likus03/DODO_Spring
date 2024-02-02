package by.it.academy.DODO.mappers;

import by.it.academy.DODO.dto.OrderDTO;
import by.it.academy.DODO.entities.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO createUserDTO(Order order);
    Order createUser(OrderDTO request);
}
