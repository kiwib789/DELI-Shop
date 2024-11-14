package com.pluralsight.deli.model;

public class Order {
    private int id;
    private String customer;
    private Sandwich sandwich;
    private double price;

    public Order(int id, String customer, Sandwich sandwich, double price) {
        this.id = id;
        this.customer = customer;
        this.sandwich = sandwich;
        this.price = price;
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
}
// add item
// get total price
