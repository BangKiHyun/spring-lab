package com.lab.springlab.async.model;

public class Cake implements Menu {

    private String name;
    private int price;

    public Cake(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
