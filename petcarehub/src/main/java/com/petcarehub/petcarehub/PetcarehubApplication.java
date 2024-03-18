package com.petcarehub.petcarehub;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.ExternalDocumentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetcarehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetcarehubApplication.class, args);
	}

	@Bean
	public OpenAPI springPetCareHubOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("PetCareHub API")
						.description("PetCareHub API reference for developers")
						.version("0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				)
				.externalDocs(new ExternalDocumentation()
						.description("PetCareHub Wiki Documentation")
						.url("https://localhost:8080/swagger-ui/4.15.5/index.html"));
	}


}