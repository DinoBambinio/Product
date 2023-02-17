package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Product {
    protected int id;
    protected String titleProduct;
    protected int price;

    public Product(int id, String titleProduct, int price) {
        this.id = id;
        this.titleProduct = titleProduct;
        this.price = price;
    }
}