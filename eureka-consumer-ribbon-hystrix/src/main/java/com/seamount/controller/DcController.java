package com.seamount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seamount.service.ConsumerService;

/**
 * 
 * @author Administrator
 * 
 * 新增ConsumerService类，然后在具体的执行逻辑的函数上增加  @HystrixCommand 注解来指定服务降级方法
 *
 */
@RestController
public class DcController {
	
	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc(){
		return consumerService.consumer();
	}
}
