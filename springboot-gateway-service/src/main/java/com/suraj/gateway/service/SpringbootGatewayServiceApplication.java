package com.suraj.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGatewayServiceApplication.class, args);
	}

}
