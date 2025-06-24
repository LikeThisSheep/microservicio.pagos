package com.edutechinnovators.paymentms.microservicio.pagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "API de Microservicio de Pagos",
    version = "1.0",
    description = "Esta es la API que gestiona la creación y consulta de boletas de pago para alumnos."
))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
