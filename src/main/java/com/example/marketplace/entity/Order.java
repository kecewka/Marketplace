package com.example.marketplace.entity;

import com.example.marketplace.enums.Statuses;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Enumerated(EnumType.STRING)
    @Column
    private Statuses status;
    @ManyToMany
    private List<Product> productList;
    @ManyToOne
    private User user;
    @Column
    private LocalDateTime orderTime;

    public Order(){}

    public Order(int id, Statuses status, List<Product> productList, User user, LocalDateTime orderTime) {
        this.id = id;
        this.status = status;
        this.productList = productList;
        this.user = user;
        this.orderTime = orderTime;
    }

    public Order(int id, Statuses status, List<Product> productList, User user) {
        this.id = id;
        this.status = status;
        this.productList = productList;
        this.user = user;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", productList=" + productList +
                ", user=" + user +
                '}';
    }
}
