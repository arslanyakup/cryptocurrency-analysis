package com.arslanyakup.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal price;

	@JsonProperty(value = "volume_24h")
	private BigDecimal volume24h;

	@JsonProperty(value = "percent_change_1h")
	private Double percentChange1h;

	@JsonProperty(value = "percent_change_24h")
	private Double percentChange24h;

	@JsonProperty(value = "percent_change_7d")
	private Double percentChange7d;

	@JsonProperty(value = "market_cap")
	private BigDecimal marketCap;

	@JsonProperty(value = "last_updated")
	private String lastUpdated;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVolume24h() {
		return volume24h;
	}

	public void setVolume24h(BigDecimal volume24h) {
		this.volume24h = volume24h;
	}

	public Double getPercentChange1h() {
		return percentChange1h;
	}

	public void setPercentChange1h(Double percentChange1h) {
		this.percentChange1h = percentChange1h;
	}

	public Double getPercentChange24h() {
		return percentChange24h;
	}

	public void setPercentChange24h(Double percentChange24h) {
		this.percentChange24h = percentChange24h;
	}

	public Double getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(Double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public BigDecimal getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(BigDecimal marketCap) {
		this.marketCap = marketCap;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
