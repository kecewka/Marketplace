package com.example.marketplace.entity;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;


public class ProductShop1 {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private int product;

    @CsvBindByPosition(position = 2)
    private int shop;

    @CsvBindByPosition(position = 3)
    private int amount;

    public ProductShop1(){}

    public ProductShop1(int id, int product, int shop, int amount) {
        this.id = id;
        this.product = product;
        this.shop = shop;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public int getAmount() { return amount;}

    public void setAmount(int amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "ProductShop{" +
                "id=" + id +
                ", product=" + product +
                ", shop=" + shop +
                ", amount=" + amount +
                '}';
    }
}
