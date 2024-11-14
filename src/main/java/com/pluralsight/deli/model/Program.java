package com.pluralsight.deli.model;

import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.PremiumToppings;
import com.pluralsight.deli.model.enums.RegularToppings;
import com.pluralsight.deli.model.enums.SandwichSize;

public class Program {
    public static void main(String[] args) {
        Order o = new Order();

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
