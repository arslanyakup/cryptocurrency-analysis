package com.arslanyakup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arslanyakup.dto.AdvancedFilterRequestDTO;
import com.arslanyakup.dto.CoinMarketCapResponseDTO;
import com.arslanyakup.dto.CryptoCurrency;
import com.arslanyakup.service.CoinMarketCapService;

@RestController
public class CoinController {

	@Autowired
	private CoinMarketCapService coinMarketCapService;

	@GetMapping("/all")
	public List<CoinMarketCapResponseDTO> allCoins() {
		return coinMarketCapService.getAllCoins();
	}

	@GetMapping("/{coinId}")
	public CoinMarketCapResponseDTO coin(@PathVariable String coinId) {
		return coinMarketCapService.getCoin(coinId);
	}

	@GetMapping("/filter/minprice/{priceTry}")
	public Set<CoinMarketCapResponseDTO> filterByMinPrice(@PathVariable Integer priceTry) {
		return coinMarketCapService.filterByMinPrice(priceTry);
	}

	// type is loss or profit
	@GetMapping("/filter/type/{type}/percentage/{percentage}")
	public List<CoinMarketCapResponseDTO> percentageProfit7d(@PathVariable String type, @PathVariable Double percentage) {
		return coinMarketCapService.percentage7dStatus(type, percentage);
	}

	@PostMapping("/filter/advanced")
	public List<CoinMarketCapResponseDTO> advancedFilterByPercentChange(@RequestBody AdvancedFilterRequestDTO advancedFilterRequestDTO) {
		return coinMarketCapService.advancedFilterByPercentChange(advancedFilterRequestDTO);
	}

	// type is increment or decrement
	@GetMapping("/sorted/{type}")
	public List<CryptoCurrency> sortedByPrice(@PathVariable String type) {
		// return coinMarketCapService.sortedByPriceTry(type);
		return null;
	}

	@GetMapping("/first/{value}")
	public Set<CoinMarketCapResponseDTO> topXCoins(@PathVariable Integer value) {
		return coinMarketCapService.getTopXCoins(value);
	}

}
