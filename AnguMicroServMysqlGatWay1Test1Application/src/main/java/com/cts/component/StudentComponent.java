package com.cts.component;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cts.model.StudentGW;

@Component
public class StudentComponent {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	public String getOtherServiceAllStudentJPA() throws URISyntaxException {
		List<ServiceInstance> otherInstance = discoveryClient.getInstances("Angu-Micro-MySql-clint-1-Test1");
		if(null == otherInstance) {
			return null;
		} else {
			ServiceInstance instance = otherInstance.get(0);
		    final String baseUrl = "http://"+instance.getHost()+":"+instance.getPort() + "/students";
		    URI uri = new URI(baseUrl);
		    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		    
		    
		    return  result.getBody().toString();
		}
	}
	
	public String postStudent(StudentGW studentGW) throws URISyntaxException {
		List<ServiceInstance> otherInstance = discoveryClient.getInstances("Angu-Micro-MySql-clint-1-Test1");
		if(null == otherInstance) {
			return null;
		} else {
			ServiceInstance instance = otherInstance.get(0);
		    final String baseUrl = "http://"+instance.getHost()+":"+instance.getPort() + "/student";
		    URI uri = new URI(baseUrl);
		    		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<StudentGW> entity = new HttpEntity<StudentGW>(studentGW, headers);
		      
		    return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class).getBody();		    
		}
	}	

}
