package com.lonelydutchhound.adoptation.configuration;

import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MigrationConfiguration {


    @Primary
    @Bean
    public FlywayProperties flywayProperties() {
        FlywayProperties flywayProperties = new FlywayProperties();

        flywayProperties.setBaselineOnMigrate(true);

        return flywayProperties;
    }
}
