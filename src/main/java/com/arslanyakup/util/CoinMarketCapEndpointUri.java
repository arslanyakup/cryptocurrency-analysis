package com.arslanyakup.util;

import org.springframework.stereotype.Component;

@Component
public class CoinMarketCapEndpointUri {

	public static final String ALL_COINS = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=10&convert=TRY";
	public static final String API_KEY = "";

	private CoinMarketCapEndpointUri() {
	}

}
