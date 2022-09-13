package ru.iriabov5.paragon.exception;

public class UpdateStatusException extends RuntimeException {
    public UpdateStatusException(Long userId) {
        super("Ошибка обновления статуса пользователя id%s".formatted(userId));
    }
}
