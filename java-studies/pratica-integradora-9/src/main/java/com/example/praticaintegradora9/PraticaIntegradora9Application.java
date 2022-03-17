package com.example.praticaintegradora9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PraticaIntegradora9Application {

	public static void main(String[] args) {
		SpringApplication.run(PraticaIntegradora9Application.class, args);
	}

}
