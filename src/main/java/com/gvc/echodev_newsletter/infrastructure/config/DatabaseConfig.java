package com.gvc.echodev_newsletter.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("${spring.datasource.url}")
                .username("${spring.datasource.username}")
                .password("${spring.datasource.password}")
                .driverClassName("${spring.datasource.driver-class-name}")
                .build();
    }
}

