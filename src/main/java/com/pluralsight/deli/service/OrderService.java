package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Product;
import com.pluralsight.deli.model.Sandwich;

public interface OrderService {
   void addProductToOrder(Order order, Product product);
   Order createNewOrder(String customerName);
   void checkOut(Order order);
   double totalPrice(Order order);
}
