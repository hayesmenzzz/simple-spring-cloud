package com.seamount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.seamount.filter.AccessFilter;

/**
 * 
 * @author Administrator
 * 
 * @EnableZuulProxy 注解开启 Zuul 的功能
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {
	
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
