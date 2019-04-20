package com.arslanyakup.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinMarketCapResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String symbol;

	private String slug;

	@JsonProperty(value = "circulating_supply")
	private Double circulatingSupply;

	@JsonProperty(value = "total_supply")
	private Double totalSupply;

	@JsonProperty(value = "max_supply")
	private Double maxSupply;

	@JsonProperty(value = "date_added")
	private String dateAdded;

	@JsonProperty(value = "num_market_pairs")
	private Integer numMarketPairs;

	private List<String> tags;

	@JsonProperty(value = "cmc_rank")
	private Integer cmcRank;

	@JsonProperty(value = "last_updated")
	private String lastUpdated;

	private Quote quote;

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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Double getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(Double circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public Double getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(Double totalSupply) {
		this.totalSupply = totalSupply;
	}

	public Double getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(Double maxSupply) {
		this.maxSupply = maxSupply;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Integer getNumMarketPairs() {
		return numMarketPairs;
	}

	public void setNumMarketPairs(Integer numMarketPairs) {
		this.numMarketPairs = numMarketPairs;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getCmcRank() {
		return cmcRank;
	}

	public void setCmcRank(Integer cmcRank) {
		this.cmcRank = cmcRank;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

}
