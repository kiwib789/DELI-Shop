package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.service.UserInterface;

public class Program {
    public static void main(String[] args) {


        Order o = new Order();
        UserInterface userInterface = new UserInterface(o);
        userInterface.displayHomeScreen();
        userInterface.displayOrderScreen();
        userInterface.addSandwichDisplay();
        userInterface.chipsDisplay();
        userInterface.drinkDisplay();
        userInterface.checkOutDisplay();

        Sandwich s = new Sandwich("Roast beef sub", BreadType.WHEAT, SandwichSize.MEDIUM,true  );
        s.addRegularTopping(RegularToppings.LETTUCE);
        s.addRegularTopping(RegularToppings.TOMATOES);
        s.addPremiumTopping((PremiumToppings.ROAST_BEEF));
        o.addProduct(s);
        System.out.println("your sandwich costs " + s.getPrice());
        System.out.println("your order costs " + o.getPrice());

        o.addProduct(new Sandwich("Empty", BreadType.WHITE, SandwichSize.SMALL, false));
        System.out.println("your order costs " + o.getPrice());

    }

}
