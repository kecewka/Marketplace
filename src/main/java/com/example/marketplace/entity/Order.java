package com.example.marketplace.entity;

import com.example.marketplace.enums.OrderStatus;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;
    @ManyToMany
    @JoinTable(name = "order_product"
            ,joinColumns = @JoinColumn(name = "order_id")
            ,inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "ordered_at")
    private LocalDateTime orderTime;

    @OneToOne
    @JoinTable(name = "order_payment"
            ,joinColumns = @JoinColumn(name = "order_id")
            ,inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private Payment payment;



    public Order(){}

    public Order(int id, OrderStatus status, List<Product> productList, User user, LocalDateTime orderTime, Payment payment) {
        this.id = id;
        this.status = status;
        this.productList = productList;
        this.user = user;
        this.orderTime = orderTime;
        this.payment = payment;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", productList=" + productList +
                ", user=" + user +
                ", orderTime=" + orderTime +
                ", payment=" + payment +
                '}';
    }
}
