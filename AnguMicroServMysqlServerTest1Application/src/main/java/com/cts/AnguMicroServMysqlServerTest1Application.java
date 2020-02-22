package com.cts;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AnguMicroServMysqlServerTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(AnguMicroServMysqlServerTest1Application.class, args);
	}

}
