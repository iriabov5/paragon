package ru.iriabov5.paragon.service;

import ru.iriabov5.paragon.entity.Status;
import ru.iriabov5.paragon.model.UserModel;

public interface UserService {
    /**
     * Добавление нового пользователя
     *
     * @param userModel - пользователь для создания
     * @return id пользователя
     */
    Long create(UserModel userModel);

    /**
     * Получение информации о пользователе
     *
     * @param id - id пользователя
     * @return - объект пользователя с заданным ID
     */
    UserModel read(Long id);

    /**
     * Изменение статуса пользователя
     *
     * @param status - новый статус
     * @param id - id пользователя которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updateStatus(Status status, Long id);
}
