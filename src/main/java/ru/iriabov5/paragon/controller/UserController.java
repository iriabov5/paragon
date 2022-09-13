package ru.iriabov5.paragon.controller;

import lombok.RequiredArgsConstructor;
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
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.read(id);
    }

    @PostMapping
    public Long addUser(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }

    @PutMapping
    public Boolean updateStatus(@RequestParam Status status, @RequestParam Long id) {
        return userService.updateStatus(status, id);
    }
}
