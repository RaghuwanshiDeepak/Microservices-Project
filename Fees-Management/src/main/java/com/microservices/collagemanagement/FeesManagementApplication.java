package com.microservices.collagemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeesManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeesManagementApplication.class, args);
	}

}
