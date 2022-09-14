package ru.iriabov5.paragon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.iriabov5.paragon.controller.UserController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ParagonApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }
}
