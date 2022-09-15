package ru.iriabov5.paragon.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long userId) {
        super("User id%d not found".formatted(userId));
    }
}