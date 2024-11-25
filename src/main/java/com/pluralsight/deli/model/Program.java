package com.pluralsight.deli.model;

import com.pluralsight.deli.receipt.ReceiptManager;
import com.pluralsight.deli.view.UserInterface;

public class Program {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

     //   Order o = new Order();
        ui.displayHomeScreen();



        ReceiptManager receiptManager = new ReceiptManager();
        // TODO figure out where to call this
       // receiptManager.receipt(o);

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
