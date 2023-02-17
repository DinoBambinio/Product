package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String titleProduct, int price, String manufacturer) {
        super(id, titleProduct, price);
        this.manufacturer = manufacturer;
    }
}