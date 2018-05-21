package com.service.provider.comm.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Dto {

	// @JsonProperty("ID")
	private String id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	private Date date;

	@JsonSerialize(nullsUsing = NumberSerialize.class)
	private BigDecimal price;

	private BigDecimal price1;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(String id) {
		this.id = id;
	}

	// @JsonFormat(shape = JsonFormat.Shape.NUMBER)
	// @JsonProperty("date")
	public Date getDate() {
		return date;
	}

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",
	// timezone = "GMT+8")
	// @JsonProperty("DATE")
	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
		// return price.setScale(2, BigDecimal.ROUND_UP);
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice1() {
		return price1;
	}

	public void setPrice1(BigDecimal price1) {
		this.price1 = price1.setScale(2, BigDecimal.ROUND_DOWN);
	}
}
