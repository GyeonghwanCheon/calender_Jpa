package com.example.calenderjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalenderJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalenderJpaApplication.class, args);
    }

}
