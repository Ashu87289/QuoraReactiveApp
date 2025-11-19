package com.ashu.Ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.directory("E:\\AlgoCamp Projects\\Ecommerce")
				.load();

		dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(),entry.getValue()));

		SpringApplication.run(EcommerceApplication.class, args);
	}

}

