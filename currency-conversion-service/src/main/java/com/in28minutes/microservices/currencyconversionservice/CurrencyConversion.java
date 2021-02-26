package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionmultiple;
	private BigDecimal quantity;
	private BigDecimal totalcalculatedamount;
	private int port;

	public CurrencyConversion() {
		super();
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionmultiple, BigDecimal quantity,
			BigDecimal totalcalculatedamount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionmultiple = conversionmultiple;
		this.quantity = quantity;
		this.totalcalculatedamount = totalcalculatedamount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getConversionmultiple() {
		return conversionmultiple;
	}

	public void setConversionmultiple(BigDecimal conversionmultiple) {
		this.conversionmultiple = conversionmultiple;
	}

	public BigDecimal getTotalcalculatedamount() {
		return totalcalculatedamount;
	}

	public void setTotalcalculatedamount(BigDecimal totalcalculatedamount) {
		this.totalcalculatedamount = totalcalculatedamount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
