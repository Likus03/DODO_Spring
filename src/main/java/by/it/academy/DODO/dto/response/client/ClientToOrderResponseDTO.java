package by.it.academy.DODO.dto.response.client;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing client information in the context of an order response.
 */
@Data
@NoArgsConstructor
public class ClientToOrderResponseDTO {

    /**
     * First name of the client.
     */
    private String firstname;

    /**
     * Phone number of the client.
     */
    private String phoneNumber;
}
