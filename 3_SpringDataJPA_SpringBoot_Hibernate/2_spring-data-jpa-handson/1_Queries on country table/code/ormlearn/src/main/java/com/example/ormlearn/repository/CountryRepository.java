package com.example.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ormlearn.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Search by partial name (case-insensitive)
    List<Country> findByCoNameContainingIgnoreCase(String partialName);

    // 2. Search by partial name and return sorted list (ascending)
    List<Country> findByCoNameContainingIgnoreCaseOrderByCoNameAsc(String partialName);

    // 3. Search countries starting with a prefix
    List<Country> findByCoNameStartingWithIgnoreCase(String prefix);
}
