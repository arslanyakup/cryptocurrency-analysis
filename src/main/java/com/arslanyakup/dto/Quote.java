package com.arslanyakup.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "TRY")
	private PriceInfo trPrice;

	public PriceInfo getTrPriceInfo() {
		return trPrice;
	}

	public void setTrPriceInfo(PriceInfo trPrice) {
		this.trPrice = trPrice;
	}

}
