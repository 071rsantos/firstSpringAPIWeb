package dio.my_first_web_api.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contato() {
        return new Contact(
            "Seu nome",
            "http://www.seusite.com.br",
            "voce@seusite.com.br"
        );
    }

    private ApiInfo informacoesApi() {
        return new ApiInfoBuilder()
            .title("Title - Rest API")
            .description("API exemplo de uso de Springboot REST API")
            .version("1.0")
            .termsOfServiceUrl("Termo de uso: Open Source")
            .license("Licença - Sua Empresa")
            .licenseUrl("http://www.seusite.com.br")
            .contact(this.contato())
            .build();
    }

    @Bean
    public Docket detalheAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("dio.my_first_web_api.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.informacoesApi())
            .consumes(new HashSet<>(Arrays.asList("application/json")))
            .produces(new HashSet<>(Arrays.asList("application/json")));
    }

}

