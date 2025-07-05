package com.example.ormlearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
public class Country {

    @Id
    private String coCode;
    private String coName;

    public String getCoCode() {
        return coCode;
    }

    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }
    @Override
    public String toString() {
        return coCode + " - " + coName;
    }
}