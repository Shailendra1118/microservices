package com.manavsa.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.manavsa.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		RestTemplate temp = new RestTemplate();
		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("from", "from");
		uriVars.put("to", "to");
		temp.setDefaultUriVariables(uriVars);
		ResponseEntity<CurrencyConversionBean> resp = temp.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVars);
		CurrencyConversionBean response = resp.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		
		CurrencyConversionBean resp = proxy.getExchangeValue(from, to);		
		return new CurrencyConversionBean(resp.getId(), from, to, resp.getConversionMultiple(), quantity, quantity.multiply(resp.getConversionMultiple()),  resp.getPort());
	}

}