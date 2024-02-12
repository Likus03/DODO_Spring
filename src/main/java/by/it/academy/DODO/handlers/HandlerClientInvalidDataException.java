package by.it.academy.DODO.handlers;

import by.it.academy.DODO.dto.response.ErrorResponse;
import by.it.academy.DODO.exceptions.ClientInvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class HandlerClientInvalidDataException {

    @ExceptionHandler(ClientInvalidDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleEmptyObject(ClientInvalidDataException ex) {
        log.error("ERROR: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }
}
