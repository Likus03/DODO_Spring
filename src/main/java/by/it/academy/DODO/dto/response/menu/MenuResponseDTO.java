package by.it.academy.DODO.dto.response.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDTO {
    private String name;
    private String describe;
    private Float cost;
}
