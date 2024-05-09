package com.api.descomplica.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springDescoAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DescomplicaAPI")
                        .description("Projeto para o módulo Prática integradora de tecnologias disruptivas")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Elisa Souza")
                                .url("https://github.com/ElisaSouzaaa"))
                        .contact(new Contact()
                                .name("Elisa Souza")
                                .url("https://www.linkedin.com/in/elisa-souzaa/")
                                .email("contato.elisasouza@hotmail.com")));
    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
                    .forEach(operation -> {
                        ApiResponses apiResponses = operation.getResponses();
                        apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                        apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                        apiResponses.addApiResponse("204", createApiResponse("Objeto excluído!"));
                        apiResponses.addApiResponse("400", createApiResponse("Requisição inválida!"));
                        apiResponses.addApiResponse("404", createApiResponse("Não encontrado!"));
                        apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));
                    }));
        };

    }
    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}