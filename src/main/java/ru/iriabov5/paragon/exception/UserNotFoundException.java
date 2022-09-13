package ru.iriabov5.paragon.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long userId) {
        super("Пользователь id%d не найден".formatted(userId));
    }
}