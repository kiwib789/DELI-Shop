package com.pluralsight.deli.receipt;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptManager {


    public void receipt(Order order) {
        LocalDateTime timeOfOrder = LocalDateTime.now();
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
        String orderNumber = timeOfOrder.format(dTF);
        String receiptFilePath = "src/main/resources/Receipts/" + orderNumber;
        StringBuilder stringBuilder = new StringBuilder();
        for (Product item : order.getProductsList()) {
            stringBuilder.append(item.productDetail());
        }
        String formattedOrder = stringBuilder.toString();
        try {
            FileWriter fileWriter = new FileWriter(receiptFilePath);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("----- Receipt -----" + "\nOrder ID: " + order.getId() + "\n" + "Customer name: "
                    + order.getCustomerName() + "\n" + "Order details:\n" + formattedOrder + "\nTotal price: $" +
                    String.format("%.2f", order.totalPrice()) + "\n------------" + "\nThanks for shopping with us!");
            bufWriter.flush();
            bufWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
