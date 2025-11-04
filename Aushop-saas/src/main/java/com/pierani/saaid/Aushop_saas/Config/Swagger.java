package com.pierani.saaid.Aushop_saas.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Value("${application.name:Aushop API}")
    private String appName;

    @Value("${application.version:1.0}")
    private String appVersion;

    @Value("${application.description:Documentação da API de gerenciamento de assinaturas}")
    private String appDescription;

    @Value("${application.contact.name:Equipe Aushop}")
    private String contactName;

    @Value("${application.contact.email:dev@example.com}")
    private String contactEmail;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Assinaturas")
                        .version("1.0")
                        .description("Documentação da API de gerenciamento de assinaturas")
                        .contact(new Contact().name("Equipe Aushop").email("dev@example.com"))
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                )
                .addServersItem(new Server().url("/").description("Default server"))
                .addTagsItem(new Tag().name("Usuários PF").description("Operações sobre usuários pessoa física"));
    }
}
