package com.example.marketplace.dto.shop;

import com.example.marketplace.dto.productshop.ProductShopDto;
import com.example.marketplace.dto.user.UserSlimDto;

import java.util.List;

public class ShopDto {
    private int id;
    private String name;
    private String address;
    private List<ProductShopDto> productList;
    private UserSlimDto user;

    public ShopDto(){}

    public ShopDto(int id, String name, String address, List<ProductShopDto> productList, UserSlimDto user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.productList = productList;
        this.user = user;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ProductShopDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductShopDto> productList) {
        this.productList = productList;
    }

    public UserSlimDto getUser() {
        return user;
    }

    public void setUser(UserSlimDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShopDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                ", user=" + user +
                '}';
    }
}
