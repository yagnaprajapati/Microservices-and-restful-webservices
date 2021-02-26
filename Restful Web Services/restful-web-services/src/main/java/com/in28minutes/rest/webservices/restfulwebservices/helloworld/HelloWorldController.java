package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller 
@RestController
public class HelloWorldController {
	// get method
	// uri -"hello-world"
	// method-"Hello World"
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloworldpathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world-Internationalization")
	public String Internationalization( ) {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
 	}

}
