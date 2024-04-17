package by.it.academy.dodo.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestPutDto {
    /**
     * The password associated with the user.
     */
    @NotBlank(message = "Password cannot be null")
    private String password;
}
