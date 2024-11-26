package com.pluralsight.deli.model;

import java.util.ArrayList;

public class Order {
    private String id;
    private String customerName;
    private ArrayList<Product> productsList;

    public Order(String id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.productsList = new ArrayList<>();
    }


    // add item
    public void addProduct(Product product) {
        productsList.add(product);

    }

    // get total price
    public double getPrice() {
        double total = 0;
        for (Product product : productsList) {
            total += product.getPrice();

        }
        return total;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }
}

