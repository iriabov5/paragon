package ru.iriabov5.paragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParagonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParagonApplication.class, args);
    }

}
