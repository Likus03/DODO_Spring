package by.it.academy.DODO.dto;

import by.it.academy.DODO.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String login;
    String password;
    Worker worker;
}
