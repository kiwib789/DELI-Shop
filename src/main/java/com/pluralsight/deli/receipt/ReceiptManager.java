package com.pluralsight.deli.receipt;

import com.pluralsight.deli.model.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {


public void receipt(Order order){
   LocalDateTime timeOfOrder = LocalDateTime.now();
   DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");

   try {
       FileWriter fileWriter = new FileWriter("./src/main/resources/Receipts/" + timeOfOrder.format(dTF));
       BufferedWriter bufWriter = new BufferedWriter(fileWriter);
       bufWriter.write(order.toString());
       bufWriter.flush();
       bufWriter.close();

   } catch (IOException e) {
       throw new RuntimeException(e);
   }
}
}



// method to save order to receipt
