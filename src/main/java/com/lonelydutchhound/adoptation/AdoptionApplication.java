package com.lonelydutchhound.adoptation;

import com.lonelydutchhound.adoptation.configuration.CoreContextConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration(exclude = {
        SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
        ManagementWebSecurityAutoConfiguration.class
})
@Import({CoreContextConfiguration.class})
public class AdoptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptionApplication.class, args);
    }

}
