package com.example.marketplace.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "product_name")
    private String name;
    @ManyToMany
    @JoinTable(name = "product_category"
            ,joinColumns = @JoinColumn(name = "product_id")
            ,inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    @Column
    private double price;

    @OneToMany(mappedBy = "product")
    private List<ProductShop> availableShopsList;


    public Product() {
    }

    public Product(int id, String name, List<Category> categories, double price) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategory() {
        return categories;
    }

    public void setCategory(List<Category> categories) {
        this.categories = categories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories='" + categories + '\'' +
                ", price=" + price +
                '}';
    }
}
