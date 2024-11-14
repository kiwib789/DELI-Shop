package com.pluralsight.deli.model;

public class Chips extends Product {

    // Constructor
    public Chips(String name, double price) {
        super(name, price);
    }
    // Price of chips
    @Override
    public double getPrice() {
        return 1.50;
    }
}