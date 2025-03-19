package com.api.GestaoHospitalar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}", version = "${info.build.version}", description = "${info.app.description}"))

@SpringBootApplication
public class GestaoHospitalarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoHospitalarApplication.class, args);
	}

}
