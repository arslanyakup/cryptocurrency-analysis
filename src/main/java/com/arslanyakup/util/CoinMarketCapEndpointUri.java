package com.arslanyakup.util;

import org.springframework.stereotype.Component;

@Component
public class CoinMarketCapEndpointUri {

	public static final String ALL_COINS = "https://api.coinmarketcap.com/v1/ticker/?convert=TRY&limit=1470";

	private CoinMarketCapEndpointUri() {
	}

}
