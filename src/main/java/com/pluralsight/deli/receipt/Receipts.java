package com.pluralsight.deli.receipt;
    import com.pluralsight.deli.model.Order;

    import java.io.*;
    import java.util.ArrayList;
import java.util.List;

    public class Receipts {
        private List<Order> orders; // List to hold all orders

        // Constructor
        public Receipts() {
            orders = new ArrayList<>();
        }

        // Method to add an order to the receipts
        public void addOrder(Order order) {
            orders.add(order);
        }

        // Method to write all orders to a CSV file
        public void writeToCSV(String fileName) throws IOException {
            // Create a FileWriter to write to a CSV file
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("OrderId,CustomerName,Items,TotalPrice");
            writer.newLine();

            // Close the writer
            writer.close();
        }

    }


