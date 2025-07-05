package com.example.ormlearn;

import com.example.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import com.example.ormlearn.entity.Country;
import com.example.ormlearn.repository.CountryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

import java.util.List;

@SpringBootApplication
public class OrmlearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);

	@Autowired
	private CountryService countryService;

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrmlearnApplication.class, args);
	}

	// Test: Find country by code
	public void testFindCountryByCode() {
		LOGGER.info("Start: testFindCountryByCode");

		try {
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}

		LOGGER.info("End: testFindCountryByCode");
	}

	// Test: Add a new country
	private void testAddCountry() {
	    LOGGER.info("Start: testAddCountry");

	    Country newCountry = new Country();
	    newCountry.setCoCode("XY");
	    newCountry.setCoName("Xylophone Land");

	    countryService.addCountry(newCountry);

	    try {
	        Country retrievedCountry = countryService.findCountryByCode("XY");
	        LOGGER.debug("Added Country: {}", retrievedCountry);
	    } catch (CountryNotFoundException e) {
	        LOGGER.error("Country not found after adding: {}", e.getMessage());
	    }

	    LOGGER.info("End: testAddCountry");
	}

	// Query Method 1: Countries containing text (e.g. 'ou')
	private void testFindByCoNameContaining() {
		LOGGER.info("Start: testFindByCoNameContaining");

		List<Country> countries = countryRepository.findByCoNameContainingIgnoreCase("ou");
		countries.forEach(c -> LOGGER.debug("Match: {}", c));

		LOGGER.info("End: testFindByCoNameContaining");
	}
}