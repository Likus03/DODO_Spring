package by.it.academy.DODO.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String describe;
    private LocalDateTime time;
}
