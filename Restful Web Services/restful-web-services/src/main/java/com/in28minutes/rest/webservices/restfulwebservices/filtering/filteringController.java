package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringController {
	@GetMapping("/filtering")
	public MappingJacksonValue retreiveSomeBean() {
		  SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		  MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		  SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mapping.setFilters(filters );
		return mapping;
	}
	@GetMapping("/filtering-list")
	public MappingJacksonValue someBeans(){
		List<SomeBean> list = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
				new SomeBean("Value1", "Value2", "Value3"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mapping.setFilters(filters );
		return mapping;
	}
}
