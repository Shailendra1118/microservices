package com.manavsa.microserices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manavsa.microserices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimitConfiguration(){
		System.out.println(configuration.toString());
		System.out.println(configuration.getMaximum());
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	

}