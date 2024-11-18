package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.receipt.ReceiptManager;

public class CheckOutScreen {
    public static void checkOutDisplay(Order order) {
        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.receipt(order);
        System.out.println(order.toString());



        }
    }

