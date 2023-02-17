package ru.netology.domain;

public class Book extends Product {

    private String author;

    public Book(int id, String titleProduct, int price, String author) {
        super(id, titleProduct, price);
        this.author = author;
    }
}