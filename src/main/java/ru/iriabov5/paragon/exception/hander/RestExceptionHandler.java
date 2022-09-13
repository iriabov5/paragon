package ru.iriabov5.paragon.exception.hander;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.iriabov5.paragon.exception.UpdateStatusException;
import ru.iriabov5.paragon.exception.UserNotFoundException;
import ru.iriabov5.paragon.model.ErrorMessageModel;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessageModel> handleException(UserNotFoundException e) {
        String message = e.getMessage();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessageModel(message));
    }

    @ExceptionHandler(UpdateStatusException.class)
    public ResponseEntity<ErrorMessageModel> handleException(UpdateStatusException e) {
        String message = e.getMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessageModel(message));
    }
}
