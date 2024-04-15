package hn.unah.lenguajes1900.data.backend_proyecto_lenguajes_cine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);}
    
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("Proyecto Final - Lenguajes de Programación 1900")
                .version("0.1.0")
                .description("Documentación y consumo de APIs hecho con Swagger/Springdocs")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}