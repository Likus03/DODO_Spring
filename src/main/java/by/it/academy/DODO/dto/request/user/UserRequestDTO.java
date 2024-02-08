package by.it.academy.DODO.dto.request.user;

import by.it.academy.DODO.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    String login;
    String password;
    Worker worker;
}
