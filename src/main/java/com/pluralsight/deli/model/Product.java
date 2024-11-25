package com.pluralsight.deli.model;

public abstract class Product {
    protected String name;

    // Constructor
    public Product(String name) {
        this.name = name;
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
    public abstract double getPrice();


    public abstract String orderDetails();
}


