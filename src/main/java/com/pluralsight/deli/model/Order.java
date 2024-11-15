package com.pluralsight.deli.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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

}

