package com.arslanyakup.dto;

import java.math.BigDecimal;

public class CryptoCurrency {

	private String id;
	private String name;
	private String symbol;
	private int rank;
	private Double usdPrice;
	private BigDecimal usd24HVolume;
	private BigDecimal marketCapUsd;
	private Double tryPrice;
	private BigDecimal try24HVolume;
	private BigDecimal marketCapTry;
	private BigDecimal totalSupply;
	private BigDecimal maxSupply;
	private BigDecimal availableSupply;
	private Double percentChange1H;
	private Double percentChange24H;
	private Double percentChange7d;
	private String lastUpdated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Double getUsdPrice() {
		return usdPrice;
	}

	public void setUsdPrice(Double usdPrice) {
		this.usdPrice = usdPrice;
	}

	public BigDecimal getUsd24HVolume() {
		return usd24HVolume;
	}

	public void setUsd24HVolume(BigDecimal usd24hVolume) {
		usd24HVolume = usd24hVolume;
	}

	public BigDecimal getMarketCapUsd() {
		return marketCapUsd;
	}

	public void setMarketCapUsd(BigDecimal marketCapUsd) {
		this.marketCapUsd = marketCapUsd;
	}

	public Double getTryPrice() {
		return tryPrice;
	}

	public void setTryPrice(Double tryPrice) {
		this.tryPrice = tryPrice;
	}

	public BigDecimal getTry24HVolume() {
		return try24HVolume;
	}

	public void setTry24HVolume(BigDecimal try24hVolume) {
		try24HVolume = try24hVolume;
	}

	public BigDecimal getMarketCapTry() {
		return marketCapTry;
	}

	public void setMarketCapTry(BigDecimal marketCapTry) {
		this.marketCapTry = marketCapTry;
	}

	public BigDecimal getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(BigDecimal totalSupply) {
		this.totalSupply = totalSupply;
	}

	public BigDecimal getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(BigDecimal maxSupply) {
		this.maxSupply = maxSupply;
	}

	public BigDecimal getAvailableSupply() {
		return availableSupply;
	}

	public void setAvailableSupply(BigDecimal availableSupply) {
		this.availableSupply = availableSupply;
	}

	public Double getPercentChange1H() {
		return percentChange1H;
	}

	public void setPercentChange1H(Double percentChange1H) {
		this.percentChange1H = percentChange1H;
	}

	public Double getPercentChange24H() {
		return percentChange24H;
	}

	public void setPercentChange24H(Double percentChange24H) {
		this.percentChange24H = percentChange24H;
	}

	public Double getPercentChange7d() {
		return percentChange7d;
	}

	public void setPercentChange7d(Double percentChange7d) {
		this.percentChange7d = percentChange7d;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "CryptoCurrency [id=" + id + ", name=" + name + ", symbol=" + symbol + ", rank=" + rank + ", usdPrice=" + usdPrice + ", usd24HVolume=" + usd24HVolume + ", marketCapUsd=" + marketCapUsd + ", tryPrice=" + tryPrice + ", try24HVolume=" + try24HVolume + ", marketCapTry=" + marketCapTry + ", totalSupply=" + totalSupply + ", maxSupply=" + maxSupply + ", availableSupply=" + availableSupply
				+ ", percentChange1H=" + percentChange1H + ", percentChange24H=" + percentChange24H + ", percentChange7d=" + percentChange7d + ", lastUpdated=" + lastUpdated + "]";
	}

}
