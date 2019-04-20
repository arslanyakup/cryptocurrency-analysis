package com.arslanyakup.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllCoinsResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "data")
	private List<CoinMarketCapResponseDTO> coinList;

	public List<CoinMarketCapResponseDTO> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinMarketCapResponseDTO> coinList) {
		this.coinList = coinList;
	}

}
