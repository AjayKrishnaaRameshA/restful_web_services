package com.ajay.restful_api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ajay.restful_api"})
@OpenAPIDefinition(
		info= @Info(
				title= "Spring boot REST API Documentation",
				description = "Spring boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name ="Ajay",
						email = "arajaykrishnaa@gmail.com",
						url="https://github.com/AjayKrishnaaRameshA?tab=repositories"
				),
				license=@License(
						name="Apache 2.0",
						url="https://github.com/AjayKrishnaaRameshA?tab=repositories"
				)
		)
)
public class RestfulApiApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}

}
