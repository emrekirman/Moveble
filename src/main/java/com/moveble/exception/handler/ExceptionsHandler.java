package com.moveble.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(MethodArgumentNotValidException exception) {
//        Map<String, String> validationErrors = new HashMap<>();
//        for (FieldError item : exceptions.getBindingResult().getFieldErrors()) {
//            validationErrors.put(item.getField(), item.getDefaultMessage());
//        }
//        return (List<String>) validationErrors.values();
        return exception.getMessage();
    }
}
