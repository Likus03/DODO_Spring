package by.it.academy.dodo.controllers.handlers;

import by.it.academy.dodo.dto.response.error.ErrorResponse;
import by.it.academy.dodo.exceptions.ClientInvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Global exception handler for handling {@link ClientInvalidDataException}.
 * Logs the error message and returns a custom {@link ErrorResponse} with a {@link HttpStatus#NOT_FOUND} status.
 */
@Slf4j
@RestControllerAdvice
public class HandlerClientInvalidDataException {

    /**
     * Handles the {@link ClientInvalidDataException} and returns a custom {@link ErrorResponse}.
     *
     * @param ex The exception to handle.
     * @return A {@link ResponseEntity} with the custom {@link ErrorResponse} and {@link HttpStatus#NOT_FOUND} status.
     */
    @ExceptionHandler(ClientInvalidDataException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleEmptyObject(ClientInvalidDataException ex) {
        log.error("ERROR: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }
}