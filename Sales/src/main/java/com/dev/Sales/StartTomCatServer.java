package com.dev.Sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class StartTomCatServer {
	public static void main(String[] args) {
		SpringApplication.run(StartTomCatServer.class, args);
	}
}
