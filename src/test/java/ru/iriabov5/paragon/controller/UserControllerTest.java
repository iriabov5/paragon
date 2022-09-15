package ru.iriabov5.paragon.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.iriabov5.paragon.entity.Status;
import ru.iriabov5.paragon.exception.UserNotFoundException;
import ru.iriabov5.paragon.model.UserModel;
import ru.iriabov5.paragon.service.UserService;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void given_ExistingId_ThenStatus200() throws Exception {
        UserModel userModel = new UserModel(
                1L,
                "Ivan",
                "ivan@yandex.ru",
                "79111111111",
                Status.ONLINE,
                LocalDateTime.now());

        when(userService.read(1L)).thenReturn(userModel);
        this.mockMvc.perform(get("/api/users/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void given_NonExistentId_ThenStatus404AndMessage() throws Exception {
        when(userService.read(1000L)).thenThrow(new UserNotFoundException(1000L));
        this.mockMvc.perform(get("/api/users/1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(Matchers.containsString("User id1000 not found")));
    }
}