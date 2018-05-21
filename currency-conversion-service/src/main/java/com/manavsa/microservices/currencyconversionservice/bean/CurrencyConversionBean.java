package com.manavsa.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private int port;
	
	public CurrencyConversionBean(){
		// used for serialization/deserialization
	}
	
	public CurrencyConversionBean(Long id, String from, String to,
			BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.port = port;
	}


	public Long getId() {
		return id;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public int getPort() {
		return port;
	}
}
