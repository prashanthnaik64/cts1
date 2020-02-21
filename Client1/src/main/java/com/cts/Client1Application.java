package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Client1Application {
	@Autowired
	@Lazy
    private EurekaClient eurekaClient;
	
	@Autowired
	private TestComponent testComponent;
	public static void main(String[] args) {
		SpringApplication.run(Client1Application.class, args);
	}
	@RequestMapping("/greeting")
    public String greeting() {
        return String.format("Hello from clent 1 ....");
    }
	
	@RequestMapping("/other-service")
    public String other() throws URISyntaxException {
		return testComponent.getOtherService();
    }
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}

}
