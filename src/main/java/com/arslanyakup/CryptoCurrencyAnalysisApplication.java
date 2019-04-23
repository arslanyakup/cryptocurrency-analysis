package com.arslanyakup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CryptoCurrencyAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyAnalysisApplication.class, args);
	}

}
