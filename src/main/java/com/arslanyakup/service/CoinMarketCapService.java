package com.arslanyakup.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arslanyakup.dto.AdvancedFilterRequestDTO;
import com.arslanyakup.dto.CoinMarketCapResponseDTO;
import com.arslanyakup.util.CoinListPrepare;
import com.arslanyakup.util.Filter;

@Service
public class CoinMarketCapService {

	@Autowired
	private CoinListPrepare coinListPrepare;

	private List<CoinMarketCapResponseDTO> coinList() {
		return coinListPrepare.allCoins();
	}

	public CoinMarketCapResponseDTO getCoin(String coinId) {
		List<CoinMarketCapResponseDTO> cryptoCurrencyList = coinList();
		return cryptoCurrencyList.stream().filter(c -> c.getId().equals(coinId)).findAny().orElse(new CoinMarketCapResponseDTO());
	}

	public Set<CoinMarketCapResponseDTO> filterByMinPrice(Integer priceTry) {
		return coinList().stream().filter(c -> c.getQuote().getTrPriceInfo().getPrice().intValue() > priceTry).sorted(Comparator.comparing(CoinMarketCapResponseDTO::getCmcRank)).collect(Collectors.toSet());
	}

	public Set<CoinMarketCapResponseDTO> getTopXCoins(Integer maxSize) {
		List<CoinMarketCapResponseDTO> cryptoCurrencies = coinList();
		return cryptoCurrencies.stream().limit(maxSize).collect(Collectors.toSet());
	}

	public List<CoinMarketCapResponseDTO> getAllCoins() {
		return coinList();
	}

	public List<CoinMarketCapResponseDTO> percentage7dStatus(String type, Double percentage) {
		return "loss".equals(type) ? coinList().stream().filter(c -> Double.valueOf(c.getQuote().getTrPriceInfo().getPercentChange7d().toString()) < Double.valueOf(-percentage)).sorted((c1, c2) -> c1.getQuote().getTrPriceInfo().getPercentChange7d().compareTo(c2.getQuote().getTrPriceInfo().getPercentChange7d())).collect(Collectors.toList())
				: coinList().stream().filter(c -> Double.valueOf(c.getQuote().getTrPriceInfo().getPercentChange7d().toString()) > Double.valueOf(percentage)).sorted((c1, c2) -> c1.getQuote().getTrPriceInfo().getPercentChange7d().compareTo(c2.getQuote().getTrPriceInfo().getPercentChange7d())).collect(Collectors.toList());
	}

	/*
	 * public List<CryptoCurrency> sortedByPriceTry(String type) { return
	 * "decrement".equals(type) ? new ArrayList<>(coinList()).stream().sorted((c1,
	 * c2) ->
	 * c1.getQuote().getTrPriceInfo().getPrice().doubleValue().compareTo(Double.
	 * valueOf(c2.getQuote().getTrPriceInfo().getPrice().doubleValue())).reversed())
	 * .collect(Collectors.toList()) : new
	 * ArrayList<>(coinList()).stream().sorted(Comparator.comparingDouble(
	 * CryptoCurrency::getTryPrice)).collect(Collectors.toList()); }
	 */
	public List<CoinMarketCapResponseDTO> advancedFilterByPercentChange(AdvancedFilterRequestDTO advancedFilterRequestDTO) {
		List<CoinMarketCapResponseDTO> cryptoCurrencies = coinList();

		if (advancedFilterRequestDTO.getPercentChange7d()) {
			if (Filter.PROFIT.toString().equals(advancedFilterRequestDTO.getPercentType7d())) {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange7d() >= advancedFilterRequestDTO.getPercentage7d()).collect(Collectors.toList());
			} else {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange7d() < -advancedFilterRequestDTO.getPercentage7d()).collect(Collectors.toList());
			}
		}
		if (advancedFilterRequestDTO.getPercentChange1d()) {
			if (Filter.PROFIT.toString().equals(advancedFilterRequestDTO.getPercentType1d())) {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange24h() >= advancedFilterRequestDTO.getPercentage1d()).collect(Collectors.toList());
			} else {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange24h() < -advancedFilterRequestDTO.getPercentage1d()).collect(Collectors.toList());
			}
		}
		if (advancedFilterRequestDTO.getPercentChange1h()) {
			if (Filter.PROFIT.toString().equals(advancedFilterRequestDTO.getPercentType1h())) {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange1h() >= advancedFilterRequestDTO.getPercentage1h()).collect(Collectors.toList());
			} else {
				cryptoCurrencies = cryptoCurrencies.stream().filter(c -> c.getQuote().getTrPriceInfo().getPercentChange1h() < -advancedFilterRequestDTO.getPercentage1h()).collect(Collectors.toList());
			}
		}
		return cryptoCurrencies;
	}

}
