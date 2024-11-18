package com.pluralsight.deli.model;

import com.pluralsight.deli.receipt.ReceiptManager;
import com.pluralsight.deli.service.ChipsScreen;
import com.pluralsight.deli.service.HomeScreen;
import com.pluralsight.deli.service.OrderScreen;

public class Program {
    public static void main(String[] args) {


        Order o = new Order();
        HomeScreen.displayHomeScreen();



        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.receipt(o);

//        Sandwich s = new Sandwich("Roast beef sub", BreadType.WHEAT, SandwichSize.MEDIUM,true  );
//        s.addRegularTopping(RegularToppings.LETTUCE);
//        s.addRegularTopping(RegularToppings.TOMATOES);
//        s.addPremiumTopping((PremiumToppings.ROAST_BEEF));
//        o.addProduct(s);
//        System.out.println("your sandwich costs " + s.getPrice());
//        System.out.println("your order costs " + o.getPrice());
//
//        o.addProduct(new Sandwich("Empty", BreadType.WHITE, SandwichSize.SMALL, false));
//        System.out.println("your order costs " + o.getPrice());

    }

}
