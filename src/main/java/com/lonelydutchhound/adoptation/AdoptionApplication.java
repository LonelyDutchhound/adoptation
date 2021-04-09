package com.lonelydutchhound.adoptation;

import com.lonelydutchhound.adoptation.configuration.CoreContextConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({CoreContextConfiguration.class})
public class AdoptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptionApplication.class, args);
    }

}
