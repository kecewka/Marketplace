package com.example.marketplace.dto.productshop;

import com.example.marketplace.dto.product.ProductSlimDto;

public class ProductShopDto {
    private ProductSlimDto product;
    private int amount;

    public ProductShopDto(){}

    public ProductShopDto(ProductSlimDto product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public ProductSlimDto getProduct() {
        return product;
    }

    public void setProduct(ProductSlimDto product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductShopDto{" +
                "product=" + product +
                ", amount=" + amount +
                '}';
    }
}
