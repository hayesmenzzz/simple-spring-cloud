package com.seamount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 主类中使用@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用
 * 
 * 初始化RestTemplate,用来真正发起Rest请求
 * 
 * @EnableDiscoveryClient 注解用来将当前应用加入到服务治理体系中
 * @author Administrator
 * 
 * 
 * 
 *         这里我们还可以使用Spring Cloud应用中的@SpringCloudApplication注解来修饰应用主类
 *         @SpringCloudApplication 这一个注解包含下面三个注解的定义(标准应用、服务发现以及断路器)
 *
 */

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
