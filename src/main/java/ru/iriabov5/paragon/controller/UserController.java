package ru.iriabov5.paragon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.iriabov5.paragon.entity.Status;
import ru.iriabov5.paragon.mapper.UserMapper;
import ru.iriabov5.paragon.model.UserModel;
import ru.iriabov5.paragon.service.UserService;

@RestController()
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        UserModel userModel = userService.read(id);
        log.info("User id%s :%s".formatted(id, userModel));
        return userModel;
    }

    @PostMapping
    public Long addUser(@RequestBody UserModel userModel) {
        Long id = userService.create(userModel);
        log.info("User id%s created: %s".formatted(id, userModel));
        return id;

    }

    @PutMapping
    public Boolean updateStatus(@RequestParam Status status, @RequestParam Long id) {
        boolean isUpdated = userService.updateStatus(status, id);
        log.info("User id%s updated: %s".formatted(id, isUpdated));
        return isUpdated;
    }
}
