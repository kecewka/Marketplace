package com.example.marketplace.dto.shop;

import com.example.marketplace.dto.productshop.ProductShopDto;

import java.util.List;

public class ShopDto {
    private int id;
    private String name;
    private String address;
    private List<ProductShopDto> proudctList;

    public ShopDto(){}

    public ShopDto(int id, String name, String address, List<ProductShopDto> proudctList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.proudctList = proudctList;
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

    public List<ProductShopDto> getProudctList() {
        return proudctList;
    }

    public void setProudctList(List<ProductShopDto> proudctList) {
        this.proudctList = proudctList;
    }

    @Override
    public String toString() {
        return "ShopDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", proudctList=" + proudctList +
                '}';
    }
}
