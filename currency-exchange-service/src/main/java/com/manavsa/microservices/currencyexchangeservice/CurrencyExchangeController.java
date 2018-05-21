package com.manavsa.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manavsa.microservices.currencyexchangeservice.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
		
		return new ExchangeValue(100L,"USD","INR", new BigDecimal("65"), Integer.parseInt(env.getProperty("local.server.port")));
		
	}

}
