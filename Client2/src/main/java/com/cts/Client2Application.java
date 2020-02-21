package com.cts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController


public class Client2Application {

	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}
	@GetMapping("/greeting")
	private String greeting() {
		return "Greeting from client 2 ...";
	}

}
