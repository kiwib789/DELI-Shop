package com.pluralsight.deli.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Order {
    private int id;
    private String customer;
    private Sandwich sandwich;
    private double totalPrice;

    public Order(int id, String customer, Sandwich sandwich, double totalPrice) {
        this.id = id;
        this.customer = customer;
        this.sandwich = sandwich;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   DateTimeFormatter format = new DateTimeFormatterBuilder("yyyyMMdd-HHmmss");
        this.dateTime = LocalDateTime.format(format);
}
// add item
// get total price
