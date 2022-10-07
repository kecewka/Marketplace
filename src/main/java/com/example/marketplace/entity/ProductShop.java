package com.example.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


@Entity
@Table(name = "product_shop")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    @Column
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
