package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="exchange_value")
public class ExchangeValue {
	@Id
	private Long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	@Column(name="conversion_multiple")
	private BigDecimal conversionmultiple;
	private int port;

	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionmultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionmultiple = conversionmultiple;
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

	public BigDecimal getConversionmultiple() {
		return conversionmultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
