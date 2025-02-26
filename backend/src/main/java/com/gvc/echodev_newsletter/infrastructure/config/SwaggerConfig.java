package com.gvc.echodev_newsletter.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Echodev Newsletter API")
                        .version("1.0")
                        .description("EchoDev-Newsletter is a Spring Boot application that allows administrators to send technology news emails to subscribed users with a single API request."));
    }
}
