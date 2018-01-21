package com.arslanyakup.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.service.CoinMarketCapService;

@RestController
public class CoinController {

	@Autowired
	private CoinMarketCapService coinMarketCapService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public Set<CryptoCurrency> allCoins() throws IOException {
		return coinMarketCapService.getAllCoins();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{coinId}")
	public CryptoCurrency coin(@PathVariable String coinId) throws IOException {
		return coinMarketCapService.getCoin(coinId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/filter/minprice/{priceTry}")
	public Set<CryptoCurrency> filterByMinPrice(@PathVariable Integer priceTry) throws IOException {
		return coinMarketCapService.filterByMinPrice(priceTry);
	}

	// type is loss or profit
	@RequestMapping(method = RequestMethod.GET, value = "/filter/type/{type}/percentage/{percentage}")
	public List<CryptoCurrency> percentageProfit7d(@PathVariable String type, @PathVariable Double percentage) throws IOException {
		return coinMarketCapService.percentage7dStatus(type, percentage);
	}

	// type is increment or decrement
	@RequestMapping(method = RequestMethod.GET, value = "/sorted/{type}")
	public List<CryptoCurrency> sortedByPrice(@PathVariable String type) throws IOException {
		return coinMarketCapService.sortedByPriceTry(type);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/first/{value}")
	public Set<CryptoCurrency> topXCoins(@PathVariable Integer value) throws IOException {
		return coinMarketCapService.getTopXCoins(value);
	}

}
