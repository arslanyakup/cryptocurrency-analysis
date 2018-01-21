package com.arslanyakup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.arslanyakup.dto.CryptoCurrency;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class CryptoCurrencyServiceUtil {

	public StringBuilder getResponseData(String uri) throws IOException {
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		return content;
	}

	public CryptoCurrency setCurrency(JsonNode currency) {
		CryptoCurrency cryptoCurrency = new CryptoCurrency();
		cryptoCurrency.setAvailableSupply(BigDecimal.valueOf(currency.at("/available_supply").asDouble()));
		cryptoCurrency.setTryPrice(currency.at("/price_try").asDouble());
		cryptoCurrency.setId(currency.at("/id").asText());
		cryptoCurrency.setLastUpdated(currency.at("/last_updated").asText());
		cryptoCurrency.setMarketCapTry(BigDecimal.valueOf(currency.at("/market_cap_try").asDouble()));
		cryptoCurrency.setMarketCapUsd(BigDecimal.valueOf(currency.at("/market_cap_usd").asDouble()));
		cryptoCurrency.setMaxSupply(BigDecimal.valueOf(currency.at("/max_supply").asDouble()));
		cryptoCurrency.setName(currency.at("/name").asText());
		cryptoCurrency.setPercentChange1H(currency.at("/percent_change_1h").asDouble());
		cryptoCurrency.setPercentChange24H(currency.at("/percent_change_24h").asDouble());
		cryptoCurrency.setPercentChange7d(currency.at("/percent_change_7d").asDouble());
		cryptoCurrency.setRank(currency.at("/rank").asInt());
		cryptoCurrency.setSymbol(currency.at("/symbol").asText());
		cryptoCurrency.setTotalSupply(BigDecimal.valueOf(currency.at("/total_supply").asDouble()));
		cryptoCurrency.setTry24HVolume(BigDecimal.valueOf(currency.at("/24h_volume_try").asDouble()));
		cryptoCurrency.setUsd24HVolume(BigDecimal.valueOf(currency.at("/24h_volume_usd").asDouble()));
		cryptoCurrency.setUsdPrice(currency.at("/price_usd").asDouble());

		return cryptoCurrency;
	}

}
