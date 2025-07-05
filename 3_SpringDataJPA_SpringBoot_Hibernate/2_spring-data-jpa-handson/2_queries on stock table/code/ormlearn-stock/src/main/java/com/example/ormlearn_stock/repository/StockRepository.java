package com.example.ormlearn_stock.repository;

import com.example.ormlearn_stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Facebook stock in Sep 2019
    List<Stock> findByCodeAndDateBetween(String code, LocalDate startDate, LocalDate endDate);

    // 2. Google stock with price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);

    // 3. Top 3 volume dates
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. 3 lowest Netflix closing prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
