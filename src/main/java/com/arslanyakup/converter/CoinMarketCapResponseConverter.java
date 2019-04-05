package com.arslanyakup.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.arslanyakup.dto.CoinResponseDTOFromCoinMarketCap;
import com.arslanyakup.dto.CryptoCurrency;

@Component
public class CoinMarketCapResponseConverter implements Function<CoinResponseDTOFromCoinMarketCap, CryptoCurrency> {

	@Override
	public CryptoCurrency apply(CoinResponseDTOFromCoinMarketCap cryptoCurrencyResponseDTO) {
		CryptoCurrency cryptoCurrency = new CryptoCurrency();
		cryptoCurrency.setAvailableSupply(cryptoCurrencyResponseDTO.getAvailable_supply());
		cryptoCurrency.setId(cryptoCurrencyResponseDTO.getId());
		cryptoCurrency.setLastUpdated(cryptoCurrencyResponseDTO.getLast_updated());
		cryptoCurrency.setMarketCapTry(cryptoCurrencyResponseDTO.getMarket_cap_try());
		cryptoCurrency.setMarketCapUsd(cryptoCurrencyResponseDTO.getMarket_cap_usd());
		cryptoCurrency.setMaxSupply(cryptoCurrencyResponseDTO.getMax_supply());
		cryptoCurrency.setName(cryptoCurrencyResponseDTO.getName());
		cryptoCurrency.setPercentChange1H(cryptoCurrencyResponseDTO.getPercent_change_1h());
		cryptoCurrency.setPercentChange24H(cryptoCurrencyResponseDTO.getPercent_change_24h());
		cryptoCurrency.setPercentChange7d(cryptoCurrencyResponseDTO.getPercent_change_7d());
		cryptoCurrency.setRank(cryptoCurrencyResponseDTO.getRank());
		cryptoCurrency.setSymbol(cryptoCurrencyResponseDTO.getSymbol());
		cryptoCurrency.setTotalSupply(cryptoCurrencyResponseDTO.getTotal_supply());
		cryptoCurrency.setUsd24HVolume(cryptoCurrencyResponseDTO.getUsd_volume_in_24h());
		cryptoCurrency.setUsdPrice(cryptoCurrencyResponseDTO.getPrice_usd());
		cryptoCurrency.setTry24HVolume(cryptoCurrencyResponseDTO.getTry_volume_in_24h());
		cryptoCurrency.setTryPrice(cryptoCurrencyResponseDTO.getPrice_try());
		return cryptoCurrency;
	}

}
