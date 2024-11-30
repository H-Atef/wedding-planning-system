package com.wedding.vendors_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VendorsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorsServiceApplication.class, args);
	}

}
