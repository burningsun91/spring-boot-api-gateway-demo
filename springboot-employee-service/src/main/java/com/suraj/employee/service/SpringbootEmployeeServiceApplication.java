package com.suraj.employee.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmployeeServiceApplication.class, args);
	}

}
