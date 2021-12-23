package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class K8sDemoAppApplication {

	@Resource
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(K8sDemoAppApplication.class, args);
	}
	
	@GetMapping("/")
	public Object hello(){
		return discoveryClient.getServices();
	}

	@GetMapping("list")
	public Object list(@RequestParam("sn") String serviceName){
		return discoveryClient.getInstances(serviceName);
	}

	

}
