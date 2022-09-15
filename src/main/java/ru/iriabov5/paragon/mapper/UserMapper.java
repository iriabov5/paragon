package ru.iriabov5.paragon.mapper;

import org.mapstruct.Mapper;
import ru.iriabov5.paragon.entity.User;
import ru.iriabov5.paragon.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel entityToDto(User user);

    User dtoToEntity(UserModel userModel);
}
