package by.it.academy.dodo.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for receiving user-related requests.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    /**
     * The login associated with the user.
     */
    @NotBlank(message = "Login cannot be null")
    private String login;

    /**
     * The password associated with the user.
     */
    @NotBlank(message = "Password cannot be null")
    private String password;
}
