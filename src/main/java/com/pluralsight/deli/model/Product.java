package com.pluralsight.deli.model;

public abstract class Product {
    protected String name;
    private double price;


    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Abstract method because each product will have a difference price
    public double getPrice() {
        return 0;
    }
}


