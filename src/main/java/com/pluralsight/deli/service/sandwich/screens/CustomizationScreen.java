package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.SandwichSize;

public class CustomizationScreen {

    public static void finishCustomization(BreadType breadType, SandwichSize sandwichSize, PremiumToppings regularToppings,
                                           PremiumToppings premiumToppings, boolean isToasted) {
        System.out.println("Description: ");

        System.out.println("Bread Type: " + (breadType != null ? breadType : "Not selected"));
        System.out.println("Sandwich Size: " + (sandwichSize != null ? sandwichSize : "Not selected"));
        System.out.println("Regular Toppings: " + (regularToppings != null ? regularToppings : "None"));
        System.out.println("Premium Toppings: " + (premiumToppings != null ? premiumToppings : "None"));
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
    }

}
