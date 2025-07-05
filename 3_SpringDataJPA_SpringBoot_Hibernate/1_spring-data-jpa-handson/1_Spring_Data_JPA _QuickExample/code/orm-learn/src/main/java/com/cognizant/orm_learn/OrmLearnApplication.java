package com.cognizant.orm_learn;

import com.cognizant.orm_learn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	public static void main(String[] args) {
		// 1. Get the application context
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		// 2. Get the CountryService bean
		countryService = context.getBean(CountryService.class);

		// 3. Call the method to retrieve countries
		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		System.out.println("Start");
		System.out.println("countries=" + countryService.getAllCountries());
		System.out.println("End");
	}
}
