package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitsservice.beans.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimits() {

		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public LimitsConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public LimitsConfiguration fallbackRetrieveConfiguration() {
		return new LimitsConfiguration(999, 9);
	}

}
