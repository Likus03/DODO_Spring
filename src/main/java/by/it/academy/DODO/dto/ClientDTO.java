package by.it.academy.DODO.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String firstname;
    private String phoneNumber;
    private String email;
    private LocalDate birthday;
}
