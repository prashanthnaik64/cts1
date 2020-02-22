package com.cts;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.cts.component.StudentComponent;
import com.cts.model.StudentGW;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AnguMicroServMysqlGatWay1Test1Application {
	@Autowired
	@Lazy
    private EurekaClient eurekaClient;
	
	@Autowired
	private StudentComponent studentComponent;
	
	public static void main(String[] args) {
		SpringApplication.run(AnguMicroServMysqlGatWay1Test1Application.class, args);
	}
	@RequestMapping("/students")
	public String getStudents() throws URISyntaxException{
		return studentComponent.getOtherServiceAllStudentJPA();
	}
	
	@PostMapping("/student")
	public void postStudent(@RequestBody StudentGW studentGW) throws URISyntaxException {
		studentComponent.postStudent(studentGW);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	

}
