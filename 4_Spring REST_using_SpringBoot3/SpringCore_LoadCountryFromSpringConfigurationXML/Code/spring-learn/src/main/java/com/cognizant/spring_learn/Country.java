package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside the Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Getting the country_code: {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Setting the country_code: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Getting the country_name: {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Setting the country_name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "COUNTRY [CODE=" + code + ", NAME=" + name + "]";
    }
}
