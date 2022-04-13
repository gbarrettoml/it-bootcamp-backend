package com.example.storage_implementation4_pi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StorageImplementation4Pi1Application {

	public static void main(String[] args) {
		SpringApplication.run(StorageImplementation4Pi1Application.class, args);
	}

}
