package by.it.academy.DODO.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    @NotNull(message = "Firstname cannot be null")
    private String firstname;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^\\+\\d{1,14}$", message = "Phone number should start with '+' and be no more than 15 long")
    private String phoneNumber;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Date of birth cannot be null")
    @Past(message = "Date of birth should be in the past")
    private LocalDate birthday;
}
