package by.it.academy.DODO.dto.request.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotEmpty(message = "Login cannot be null")
    String login;

    @NotEmpty(message = "Password cannot be null")
    String password;
}
