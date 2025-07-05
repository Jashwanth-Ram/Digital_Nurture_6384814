package com.example.ormlearn_stock;

import com.example.ormlearn_stock.entity.Stock;
import com.example.ormlearn_stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmlearnStockApplication implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmlearnStockApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Facebook stocks in Sep 2019:");
        List<Stock> fbStocks = stockRepository.findByCodeAndDateBetween("FB",
                LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        fbStocks.forEach(System.out::println);

        System.out.println("\nGoogle stocks with close > 1250:");
        stockRepository.findByCodeAndCloseGreaterThan("GOOGL", 1250)
                .forEach(System.out::println);

        System.out.println("\nTop 3 highest volume days:");
        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

        System.out.println("\n3 Lowest Netflix stock closing prices:");
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}
