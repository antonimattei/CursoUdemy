package com.cursoapirestfull.api;

import com.cursoapirestfull.api.utils.SenhaUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestfullApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senhaEconded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha encoded: "+ senhaEconded);

			senhaEconded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Mesma senha, encodede novo: "+senhaEconded);

			System.out.println("Senha válida: "+ SenhaUtils.senhaValida("123456",senhaEconded));
		};
	}
}