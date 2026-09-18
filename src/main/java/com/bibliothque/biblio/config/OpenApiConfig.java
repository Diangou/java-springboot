package com.bibliothque.biblio.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI biblioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biblio API")
                        .description("API de gestion de la bibliotheque (adherents, cartes, livres, auteurs, artistes, CD)")
                        .version("0.0.1"));
    }
}
