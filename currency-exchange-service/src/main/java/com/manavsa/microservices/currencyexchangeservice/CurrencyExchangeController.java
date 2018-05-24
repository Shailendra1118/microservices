package com.manavsa.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manavsa.microservices.currencyexchangeservice.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
		log.info("TRACING:: getExchangeValue{}, {} "+from, to);
		return new ExchangeValue(100L,"USD","INR", new BigDecimal("65"), Integer.parseInt(env.getProperty("local.server.port")));
		
	}

}
