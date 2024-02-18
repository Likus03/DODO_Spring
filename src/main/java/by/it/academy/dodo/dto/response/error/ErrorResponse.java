package by.it.academy.dodo.dto.response.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for representing error responses.
 */
@Data
@Builder
public class ErrorResponse {

    /**
     * The error message.
     */
    private String message;

    /**
     * The timestamp when the error occurred.
     */
    private LocalDateTime time;
}

