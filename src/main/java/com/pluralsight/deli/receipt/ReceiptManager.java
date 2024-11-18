package com.pluralsight.deli.receipt;

import com.pluralsight.deli.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

public void receipt(Order order){
    LocalDateTime today = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
    DateTimeFormatter ordNum = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    String ordNumFormat = today.format(ordNum);
    String formattedToday = today.format(formatter);
    String receiptFilepath = "src/main/resources/receipts/" + formattedToday + ".txt";
}
}
