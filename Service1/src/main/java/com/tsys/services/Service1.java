package com.tsys.services;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service1 {
	
	Logger logger = Logger.getGlobal();
	//http://host:port/message?name=xxxxxx
	@RequestMapping(path="message",method=RequestMethod.GET)
	public String getMessage(@RequestParam("name") String name ) {
		logger.info("Welcome to the WebServices..........................");
		logger.info("Recieved request for.........................."+name);
		return "Welcome " + name;
	}

}
