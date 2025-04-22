package com.microservices.management.Management_DiscoverServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ManagementDiscoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementDiscoverServerApplication.class, args);
	}

}
