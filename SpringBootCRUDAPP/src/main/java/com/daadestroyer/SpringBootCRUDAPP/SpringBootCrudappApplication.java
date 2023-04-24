package com.daadestroyer.SpringBootCRUDAPP;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title="SpringBoot CRUD Rest API Documentatin",
                description="SpringBoot Rest API Documentation with MySQL Dataabase",
                version="v1.0",
                contact = @Contact(
                        name="Shubham",
                        email="nigamshubham2000@gmail.com",
                        url="https://shubhamnigam.netlify.app/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url="https://www.linkedin.com/in/daadestroyer/"
                )

        )
)
public class SpringBootCrudappApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudappApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
