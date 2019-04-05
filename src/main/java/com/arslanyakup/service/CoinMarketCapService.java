package com.arslanyakup.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arslanyakup.converter.CoinMarketCapResponseConverter;
import com.arslanyakup.dto.CoinResponseDTOFromCoinMarketCap;
import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.util.CoinMarketCapEndpointUri;

@Service
public class CoinMarketCapService {

	@Autowired
	private CoinMarketCapResponseConverter capResponseConverter;

	@Autowired
	private RestTemplate restTemplate;

	public CryptoCurrency getCoin(String coinId) {
		Set<CryptoCurrency> cryptoCurrencyList = getAllCoinListPrepare();
		return cryptoCurrencyList.stream().filter(c -> c.getId().equals(coinId)).findAny().orElse(new CryptoCurrency());
	}

	public Set<CryptoCurrency> filterByMinPrice(Integer priceTry) {
		Set<CryptoCurrency> cryptoCurrencies = getAllCoinListPrepare();
		return cryptoCurrencies.stream().filter(c -> c.getTryPrice().intValue() > priceTry).sorted(Comparator.comparing(CryptoCurrency::getRank)).collect(Collectors.toSet());
	}

	public Set<CryptoCurrency> getTopXCoins(Integer maxSize) {
		Set<CryptoCurrency> cryptoCurrencies = getAllCoinListPrepare();
		return cryptoCurrencies.stream().limit(maxSize).collect(Collectors.toSet());
	}

	public Set<CryptoCurrency> getAllCoins() {
		return getAllCoinListPrepare();
	}

	public List<CryptoCurrency> percentage7dStatus(String type, Double percentage) {
		Set<CryptoCurrency> cryptoCurrencyList = new HashSet<>(getAllCoinListPrepare());
		return "loss".equals(type) ? cryptoCurrencyList.stream().filter(c -> Double.valueOf(c.getPercentChange7d().toString()) < Double.valueOf(-percentage)).sorted(Comparator.comparing(CryptoCurrency::getPercentChange7d)).collect(Collectors.toList()) : cryptoCurrencyList.stream().filter(c -> Double.valueOf(c.getPercentChange7d().toString()) > Double.valueOf(percentage)).sorted(Comparator.comparing(CryptoCurrency::getPercentChange7d)).collect(Collectors.toList());
	}

	public List<CryptoCurrency> sortedByPriceTry(String type) {
		Set<CryptoCurrency> cryptoCurrencyList = new HashSet<>(getAllCoinListPrepare());
		return "decrement".equals(type) ? new ArrayList<>(cryptoCurrencyList).stream().sorted(Comparator.comparingDouble(CryptoCurrency::getTryPrice).reversed()).collect(Collectors.toList()) : new ArrayList<>(cryptoCurrencyList).stream().sorted(Comparator.comparingDouble(CryptoCurrency::getTryPrice)).collect(Collectors.toList());
	}

	private Set<CryptoCurrency> getAllCoinListPrepare() {
		Set<CryptoCurrency> cryptoCurrencies = new HashSet<>();
		CoinResponseDTOFromCoinMarketCap[] currencyList = restTemplate.getForObject(CoinMarketCapEndpointUri.ALL_COINS, CoinResponseDTOFromCoinMarketCap[].class);
		Arrays.asList(currencyList).stream().forEach(c -> cryptoCurrencies.add(capResponseConverter.apply(c)));
		return cryptoCurrencies;
	}

}
