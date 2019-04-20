package com.arslanyakup.util;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HeadersUtil {

	private HeadersUtil() {
	}

	public static HttpHeaders headers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("X-CMC_PRO_API_KEY", CoinMarketCapEndpointUri.API_KEY);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
