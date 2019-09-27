package com.suraj.proxy.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
public class SpringbootProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProxyServiceApplication.class, args);
	}

}
