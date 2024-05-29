package com.clickquartos.corecadastroquarto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoreCadastroQuartoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreCadastroQuartoApplication.class, args);
	}

}
