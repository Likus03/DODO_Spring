package by.it.academy.dodo.controllers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Global exception handler for handling {@link MethodArgumentNotValidException}.
 * Returns a map of field errors with their corresponding error messages and {@link HttpStatus#BAD_REQUEST} status.
 */
@ControllerAdvice
public class HandlerValidationException {

    /**
     * Handles the {@link MethodArgumentNotValidException} and returns a map of field errors.
     *
     * @param ex The exception to handle.
     * @return A map of field errors with their corresponding error messages.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(getErrors(errors));
        return errors;
    }

    private Consumer<FieldError> getErrors(Map<String, String> errors) {
        return error -> errors.put(error.getField(), error.getDefaultMessage());
    }
}
