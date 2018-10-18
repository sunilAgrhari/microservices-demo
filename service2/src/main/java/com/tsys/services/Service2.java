package com.tsys.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Service2 {
	
	@RequestMapping(path="service2",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="backup")
	public String primary() {
		//when it fail it will got backup method
		throw new RuntimeException();
		//return "Acutal Plan";
		
	}
  
	//Its is for backup
	public String backup() {
		return "backup Plan";
		
	}
  
}
