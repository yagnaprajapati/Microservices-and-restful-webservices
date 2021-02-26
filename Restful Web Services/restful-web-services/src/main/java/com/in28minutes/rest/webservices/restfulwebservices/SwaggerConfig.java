package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableWebMvc

//@EnableSwagger2
public class SwaggerConfig {
	 /* public static final Contact DEFAULT_CONTACT = new Contact("Yagnakumar Prajapati", "www.google.co.in", "yprajapati40@gmail.com");
	  public static final ApiInfo dEFAULT_APIINFO = new ApiInfo("This is Awesome APi Documentation", "Awesome Api Descriptions", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> dEFAULT_CONSUMES_AND_PRODUCE =
			new HashSet<String>(Arrays.asList("application/json","application/xml"));

	 

	@Bean
	 public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(dEFAULT_APIINFO)
				.consumes(dEFAULT_CONSUMES_AND_PRODUCE)
				.produces(dEFAULT_CONSUMES_AND_PRODUCE);
	 }*/
}
