package com.example.marketplace.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String username;
    @Column
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role"
            ,joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles> rolesList;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public User(){}

    public User(int id, String username, String password, List<Roles> role, List<Order> orderList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rolesList = role;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRole() {
        return rolesList;
    }

    public void setRole(List<Roles> role) {
        this.rolesList = role;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rolesList=" + rolesList +
                ", orderList=" + orderList +
                '}';
    }
}
