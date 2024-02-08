package by.it.academy.DODO.dto.request.client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientToOrderRequestDTO {
    private String firstname;
    private String phoneNumber;
}
