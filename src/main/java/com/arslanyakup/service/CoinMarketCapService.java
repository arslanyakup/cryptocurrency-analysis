package com.arslanyakup.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.util.CoinMarketCapEndpointUri;
import com.arslanyakup.util.CryptoCurrencyServiceUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoinMarketCapService {

	@Autowired
	private CryptoCurrencyServiceUtil cryptoCurrencyServiceUtil;

	public CryptoCurrency getCoin(String coinId) throws IOException {
		Set<CryptoCurrency> cryptoCurrencyList = getAllCoinListPrepare();
		return cryptoCurrencyList.stream().filter(c -> c.getId().equals(coinId)).findAny().orElse(new CryptoCurrency());
	}

	public Set<CryptoCurrency> filterByMinPrice(Integer priceTry) throws IOException {
		Set<CryptoCurrency> cryptoCurrencies = getAllCoinListPrepare();
		return cryptoCurrencies.stream().filter(c -> c.getTryPrice().intValue() > priceTry).collect(Collectors.toSet());
	}

	public Set<CryptoCurrency> getTopXCoins(Integer maxSize) throws IOException {
		Set<CryptoCurrency> cryptoCurrencies = getAllCoinListPrepare();
		return cryptoCurrencies.stream().limit(maxSize).collect(Collectors.toSet());
	}

	public Set<CryptoCurrency> getAllCoins() throws IOException {
		return getAllCoinListPrepare();
	}

	public List<CryptoCurrency> percentage7dStatus(String type, Double percentage) throws IOException {
		Set<CryptoCurrency> cryptoCurrencyList = new HashSet<>(getAllCoinListPrepare());
		return "loss".equals(type) ? cryptoCurrencyList.stream().filter(c -> Double.valueOf(c.getPercentChange7d().toString()) < Double.valueOf(-percentage)).sorted(Comparator.comparing(CryptoCurrency::getPercentChange7d)).collect(Collectors.toList()) : cryptoCurrencyList.stream().filter(c -> Double.valueOf(c.getPercentChange7d().toString()) > Double.valueOf(percentage)).sorted(Comparator.comparing(CryptoCurrency::getPercentChange7d)).collect(Collectors.toList());
	}

	public List<CryptoCurrency> sortedByPriceTry(String type) throws IOException {
		Set<CryptoCurrency> cryptoCurrencyList = new HashSet<>(getAllCoinListPrepare());
		return "decrement".equals(type) ? new ArrayList<>(cryptoCurrencyList).stream().sorted(Comparator.comparingDouble(CryptoCurrency::getTryPrice).reversed()).collect(Collectors.toList()) : new ArrayList<>(cryptoCurrencyList).stream().sorted(Comparator.comparingDouble(CryptoCurrency::getTryPrice)).collect(Collectors.toList());
	}

	private Set<CryptoCurrency> getAllCoinListPrepare() throws IOException {
		Set<CryptoCurrency> cryptoCurrencies = new HashSet<>();
		StringBuilder content = cryptoCurrencyServiceUtil.getResponseData(CoinMarketCapEndpointUri.ALL_COINS);
		JsonNode jsonNode = new ObjectMapper().readTree(content.toString());
		for (JsonNode currency : jsonNode) {
			cryptoCurrencies.add(cryptoCurrencyServiceUtil.setCurrency(currency));
		}
		return cryptoCurrencies;
	}

}
