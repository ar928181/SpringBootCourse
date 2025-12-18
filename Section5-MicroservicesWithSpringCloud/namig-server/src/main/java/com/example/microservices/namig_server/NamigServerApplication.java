package com.example.microservices.namig_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamigServerApplication.class, args);
	}

}
