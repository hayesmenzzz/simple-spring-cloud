package com.seamount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author Administrator
 *
 *         在客户端5秒没有返回数据，触发服务请求超时异常，服务消费者通过 @HystrixCommand
 *         注解中指定的降级逻辑进行执行，因此该请求的结果返回了 方法fallback() 中的结果
 *         这样的机制对自身服务起到了基础的保护，同时还为异常情况提供了自动的服务降级切换机制
 *
 */
@Service
public class ConsumerService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}

	public String fallback() {
		return "fallback";
	}
}
