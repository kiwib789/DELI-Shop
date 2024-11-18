package com.pluralsight.deli.model;

import java.util.ArrayList;

public class Order {
    private int id;
    private String customer;
    private ArrayList<Product> products = new ArrayList<>();


    // add item
    public void addProduct(Product product) {
        products.add(product);

    }

    // get total price
    public double getPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();

        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", products=" + products +
                getPrice() +
                '}';
    }
}

