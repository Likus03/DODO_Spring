package by.it.academy.DODO.dto.request.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for receiving user-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    /**
     * The login associated with the user.
     */
    @NotEmpty(message = "Login cannot be null")
    private String login;

    /**
     * The password associated with the user.
     */
    @NotEmpty(message = "Password cannot be null")
    private String password;
}
