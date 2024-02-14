package by.it.academy.DODO.handlers;

import by.it.academy.DODO.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
/**
 * Global exception handler for handling {@link DataIntegrityViolationException}.
 * Logs the error message and returns a custom {@link ErrorResponse} with a {@link HttpStatus#BAD_REQUEST} status.
 */
@Slf4j
@ControllerAdvice
public class HandlerDataIntegrityViolationException {

    /**
     * Handles the {@link DataIntegrityViolationException} and returns a custom {@link ErrorResponse}.
     *
     * @param ex The exception to handle.
     * @return A {@link ResponseEntity} with the custom {@link ErrorResponse} and {@link HttpStatus#BAD_REQUEST} status.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationExceptions(DataIntegrityViolationException ex){
        log.error("ERROR: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("ERROR: " + ex.getMessage())
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }
}
