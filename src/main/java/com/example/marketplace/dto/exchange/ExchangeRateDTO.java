package com.example.marketplace.dto.exchange;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExchangeRateDTO {
    private int foreignCurAmount;
    private String foreignCurFullName;
    private String foreignCurCode;
    private final String TENGE_CODE = "KZT";
    private final String TENGE_FULL = "КАЗАХСТАНСКИХ ТЕНГЕ";
    private double tengeAmount;

    private LocalDate date;


    public ExchangeRateDTO(){}

    public ExchangeRateDTO(int foreignCurAmount, String foreignCurFullName, String foreignCurCode, double tengeAmount, LocalDate date) {
        this.foreignCurAmount = foreignCurAmount;
        this.foreignCurFullName = foreignCurFullName;
        this.foreignCurCode = foreignCurCode;
        this.tengeAmount = tengeAmount;
        this.date = date;
    }

    public int getForeignCurAmount() {
        return foreignCurAmount;
    }

    public void setForeignCurAmount(int foreignCurAmount) {
        this.foreignCurAmount = foreignCurAmount;
    }

    public String getForeignCurFullName() {
        return foreignCurFullName;
    }

    public void setForeignCurFullName(String foreignCurFullName) {
        this.foreignCurFullName = foreignCurFullName;
    }

    public String getForeignCurCode() {
        return foreignCurCode;
    }

    public void setForeignCurCode(String foreignCurCode) {
        this.foreignCurCode = foreignCurCode;
    }

    public String getTENGE_CODE() {
        return TENGE_CODE;
    }

    public String getTENGE_FULL() {
        return TENGE_FULL;
    }

    public double getTengeAmount() {
        return tengeAmount;
    }

    public void setTengeAmount(double tengeAmount) {
        this.tengeAmount = tengeAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeRateDTO{" +
                "foreignCurAmount=" + foreignCurAmount +
                ", foreignCurFullName='" + foreignCurFullName + '\'' +
                ", foreignCurCode='" + foreignCurCode + '\'' +
                ", TENGE_CODE='" + TENGE_CODE + '\'' +
                ", TENGE_FULL='" + TENGE_FULL + '\'' +
                ", tengeAmount=" + tengeAmount +
                '}';
    }
}
