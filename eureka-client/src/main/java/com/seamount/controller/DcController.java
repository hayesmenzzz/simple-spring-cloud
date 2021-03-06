package com.seamount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public String dc() throws InterruptedException{
		//为了触发服务降级逻辑，我们可以将服务提供者eureka-client的逻辑加一些延迟
		Thread.sleep(5000L);
		String services = "Service: "+discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
