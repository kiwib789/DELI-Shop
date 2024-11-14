package com.pluralsight.deli.model;

public class Chips extends Product {

    // Constructor
    public Chips(String name) {
        super(name);
    }
    // Price of chips
    @Override
    public double getPrice() {
        return 1.50;
    }
}