package com.arslanyakup.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.arslanyakup.dto.AllCoinsResponseDTO;
import com.arslanyakup.dto.CoinMarketCapResponseDTO;

public class CoinListPrepare {

	@Autowired
	private RestTemplate restTemplate;

	public List<CoinMarketCapResponseDTO> allCoins() {
		HttpEntity<HeadersUtil> entity = new HttpEntity<HeadersUtil>(HeadersUtil.headers());
		AllCoinsResponseDTO coinResponseDTO = restTemplate.exchange(CoinMarketCapEndpointUri.ALL_COINS, HttpMethod.GET, entity, AllCoinsResponseDTO.class).getBody();
		return coinResponseDTO.getCoinList();
	}
}
