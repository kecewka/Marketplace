package com.example.marketplace.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "foreign_cur_amount")
    private int foreignCurAmount;
    @Column(name = "foreign_cur_code")
    private String foreignCurCode;
    @Column(name = "foreign_cur_name")
    private String foreignCurName;
    @Column(name = "tenge_amount")
    private double tengeAmount;
    @Column(name = "rate_date")
    private LocalDate rateDate;

    public ExchangeRate(){}

    public ExchangeRate(int id, int foreignCurAmount, String foreignCurCode, String foreignCurName, double tengeAmount, LocalDate rateDate) {
        this.id = id;
        this.foreignCurAmount = foreignCurAmount;
        this.foreignCurCode = foreignCurCode;
        this.foreignCurName = foreignCurName;
        this.tengeAmount = tengeAmount;
        this.rateDate = rateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getForeignCurAmount() {
        return foreignCurAmount;
    }

    public void setForeignCurAmount(int foreignCurAmount) {
        this.foreignCurAmount = foreignCurAmount;
    }

    public String getForeignCurCode() {
        return foreignCurCode;
    }

    public void setForeignCurCode(String foreignCurCode) {
        this.foreignCurCode = foreignCurCode;
    }

    public String getForeignCurName() {
        return foreignCurName;
    }

    public void setForeignCurName(String foreignCurName) {
        this.foreignCurName = foreignCurName;
    }

    public double getTengeAmount() {
        return tengeAmount;
    }

    public void setTengeAmount(double tengeAmount) {
        this.tengeAmount = tengeAmount;
    }

    public LocalDate getRateDate() {
        return rateDate;
    }

    public void setRateDate(LocalDate rateDate) {
        this.rateDate = rateDate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", foreignCurAmount=" + foreignCurAmount +
                ", foreignCurCode='" + foreignCurCode + '\'' +
                ", foreignCurName='" + foreignCurName + '\'' +
                ", tengeAmount=" + tengeAmount +
                ", rateDate=" + rateDate +
                '}';
    }
}
