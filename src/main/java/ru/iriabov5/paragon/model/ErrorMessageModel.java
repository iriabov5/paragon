package ru.iriabov5.paragon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessageModel {
    private String message;
    @JsonFormat(pattern = "dd.MM.yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public ErrorMessageModel(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
