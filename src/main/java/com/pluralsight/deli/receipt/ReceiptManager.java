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


public void receipt(Order order){
   LocalDateTime timeOfOrder = LocalDateTime.now();
   DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");
   StringBuilder stringBuilder = new StringBuilder();
   for (Product item : order.getProductsList()){
       stringBuilder.append(item.getName());
   }
   String formattedOrder = stringBuilder.toString();
   try {
       FileWriter fileWriter = new FileWriter("./src/main/resources/Receipts/" + timeOfOrder.format(dTF));
       BufferedWriter bufWriter = new BufferedWriter(fileWriter);
       bufWriter.write(order.getId() + "\n" + order.getCustomerName() + "\n" + formattedOrder);
       bufWriter.flush();
       bufWriter.close();

   } catch (IOException e) {
       throw new RuntimeException(e);
   }
}
}



// method to save order to receipt
