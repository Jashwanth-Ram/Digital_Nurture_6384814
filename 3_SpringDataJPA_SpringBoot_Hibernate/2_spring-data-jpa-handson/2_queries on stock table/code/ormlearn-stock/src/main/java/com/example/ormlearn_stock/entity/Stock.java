package com.example.ormlearn_stock.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stId;

    @Column(name = "st_code")
    private String code;

    @Column(name = "st_date")
    private LocalDate date;

    @Column(name = "st_open")
    private BigDecimal open;

    @Column(name = "st_close")
    private BigDecimal close;

    @Column(name = "st_volume")
    private BigDecimal volume;

    // Getters and Setters

    @Override
    public String toString() {
        return "Stock{" +
                "stId=" + stId +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
