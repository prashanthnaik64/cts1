package com.cts;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestComponent {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	public String getOtherService() throws URISyntaxException {
		List<ServiceInstance> otherInstance = discoveryClient.getInstances("mserv-client-2-app-2");
		if(null == otherInstance) {
			return "Other instance not found";
		} else {
			ServiceInstance instance = otherInstance.get(0);
		    final String baseUrl = "http://"+instance.getHost()+":"+instance.getPort() + "/greeting";
		    URI uri = new URI(baseUrl);
		    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		    return result.getBody();
		}
	}

}
