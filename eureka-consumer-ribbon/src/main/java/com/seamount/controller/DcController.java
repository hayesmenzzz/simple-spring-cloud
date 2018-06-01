package com.seamount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//	@Autowired
//	LoadBalancerClient loadBalancerClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * 去掉原来通过LoadBalancerClient选取实例和拼接URL的步骤，直接通过RestTemplate发起请求。
	 * @return
	 */
	@GetMapping("/consumer")
	public String dc(){
		//通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，这个服务实例的基本信息存储在ServiceInstance
//		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		//通过这些对象中的信息拼接出访问/dc接口的详细地址
//		String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
//		System.out.println(url);
		//最后再利用RestTemplate对象实现对服务提供者接口的调用。
//		return restTemplate.getForObject(url, String.class);
		
		
		
		
		//这里请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成
		//这样的请求可以调用成功,因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例
		//并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
		
	}
}
