package com.example.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ormlearn.entity.Country;
import com.example.ormlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Find country by code
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> optional = countryRepository.findById(code);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
    }

    // Add new country
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Update country by code
    public Country updateCountry(String code, Country updatedCountry) {
        Optional<Country> optional = countryRepository.findById(code);
        if (optional.isPresent()) {
            Country country = optional.get();
            country.setCoName(updatedCountry.getCoName());
            return countryRepository.save(country);
        } else {
            throw new RuntimeException("Country not found for update with code: " + code);
        }
    }

    // Delete country by code
    public void deleteCountry(String code) {
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
        } else {
            throw new RuntimeException("Country not found for delete with code: " + code);
        }
    }

    // ✅ Search countries by name (contains text), sorted by name (A-Z)
    public List<Country> searchByName(String name) {
        return countryRepository.findByCoNameContainingIgnoreCaseOrderByCoNameAsc(name);
    }

    // 🔤 Optional: Search countries starting with a letter (can be added to controller)
    public List<Country> searchByPrefix(String prefix) {
        return countryRepository.findByCoNameStartingWithIgnoreCase(prefix);
    }
}
