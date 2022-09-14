package ru.iriabov5.paragon.exception;

public class UpdateStatusException extends RuntimeException {
    public UpdateStatusException(Long userId) {
        super("Exception update user id%s status".formatted(userId));
    }
}
