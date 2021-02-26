package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	private Logger Logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertcurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion response = responseEntity.getBody();
		return new CurrencyConversion(response.getId(), from, to, response.getConversionmultiple(), quantity,
				quantity.multiply(response.getConversionmultiple()), response.getPort());
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertcurrencyfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion response = proxy.retrieveCurrency(from, to);
		Logger.info("{}",response);

		return new CurrencyConversion(response.getId(), from, to, response.getConversionmultiple(), quantity,
				quantity.multiply(response.getConversionmultiple()), response.getPort());
	}
	 
}
