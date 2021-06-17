package com.moveble.core.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
