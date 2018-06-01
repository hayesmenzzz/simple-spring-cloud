package com.seamount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.seamount.service.DcClient;

/**
 * 通过定义的feign客户端来调用服务提供方的接口
 * @author Administrator
 *
 */
@RestController
public class DcController {

	@Autowired
	DcClient dcClient;
	
	@GetMapping("/consumer")
	public String dc() {
		return dcClient.consumer();
	}
	
	
	
	
	
	
	
}
