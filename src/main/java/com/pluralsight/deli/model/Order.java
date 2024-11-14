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

    public void addProduct(Product product) {
        products.add(product);

    }


    // date and time for receipt
    private static void writeToFile(Order order) {
        ArrayList<Order> result = new ArrayList<>();
        try {
            try {
                FileWriter fileWriter = new FileWriter("src/main/resources/receipts.csv", true);
                BufferedWriter bufWriter = new BufferedWriter(fileWriter);
                // splits up the format of the csv file in correct order
//                bufWriter.write(
//                        order.getDate() + "|" + order.getTime() + "|" +
//                                +"|" +
//                                +"|" +
//                                order.getAmount() + "\n");
                bufWriter.close();
            } catch (IOException e) {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();

        }
        return total;
    }
}
// add item

// get total price
