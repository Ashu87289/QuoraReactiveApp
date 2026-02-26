package com.algocamp.EcommerceUpdated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceUpdatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceUpdatedApplication.class, args);
	}

}
