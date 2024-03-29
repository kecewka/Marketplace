package com.example.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;

import javax.persistence.*;


@Entity
@Table(name = "product_shop")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @CsvBindByPosition(position = 0)
    @CsvNumber(value = "Integer")
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @CsvNumber(value = "Integer")
    @CsvBindByPosition(position = 1)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    @CsvNumber(value = "Integer")
    @CsvBindByPosition(position = 2)
    private Shop shop;
    @Column
    @CsvNumber(value = "Integer")
    @CsvBindByPosition(position = 3)
    private int amount;

    public ProductShop(){}

    public ProductShop(int id, Product product, Shop shop, int amount) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
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
