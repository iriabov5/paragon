package ru.iriabov5.paragon.model;

import lombok.Value;
import ru.iriabov5.paragon.entity.Status;

import java.time.LocalDateTime;

@Value
public class UserModel {
    Long id;
    String name;
    String email;
    String phoneNumber;
    Status status;
    LocalDateTime modifiedStatusDate;
}
