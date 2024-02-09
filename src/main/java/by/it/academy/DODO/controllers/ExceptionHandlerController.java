package by.it.academy.DODO.controllers;

import by.it.academy.DODO.dto.response.ErrorResponse;
import by.it.academy.DODO.exceptions.EmptyObjectException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {
    private final MessageSource messageSource;

    @ExceptionHandler(EmptyObjectException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleEmptyObject(EmptyObjectException ex) {
        log.warn("EXCEPTION: {}", ex.getMessage());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(
                        messageSource.getMessage("information.missing.message",
                                new Object[]{},
                                "ERROR", LocaleContextHolder.getLocale()))
                .describe(
                        messageSource.getMessage("information.missing.describe",
                                new Object[]{},
                                LocaleContextHolder.getLocale()))
                .time(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }
}
