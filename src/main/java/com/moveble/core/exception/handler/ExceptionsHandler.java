package com.moveble.core.exception.handler;

import com.moveble.core.exception.TokenAlreadyHaveException;
import com.moveble.core.exception.TokenNotEqualException;
import com.moveble.core.exception.TokenNotFoundException;
import com.moveble.core.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
//        Map<String, String> validationErrors = new HashMap<>();
//        for (FieldError item : exceptions.getBindingResult().getFieldErrors()) {
//            validationErrors.put(item.getField(), item.getDefaultMessage());
//        }
//        return (List<String>) validationErrors.values();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(TokenAlreadyHaveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleTokenAlreadyHaveException(TokenAlreadyHaveException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(TokenNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<?> handleTokenNotFoundException(TokenNotFoundException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(TokenNotEqualException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<String> handleTokenNotEqualException(TokenNotEqualException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }
}
