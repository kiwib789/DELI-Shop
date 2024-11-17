package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.enums.SandwichSize;

public class CustomizationScreen {

    private void finishCustomization(BreadType breadType, SandwichSize sandwichSize, RegularToppings regularToppings,
                                     PremiumToppings premiumToppings, boolean isToasted) {
        System.out.println("Your custom sandwich is complete.");
        System.out.println("Description: ");
        System.out.println("Bread Type: " + breadType);
        System.out.println("Sandwich Size: " + sandwichSize);
        System.out.println("Regular Toppings: " + regularToppings);
        System.out.println("Premium Toppings: " + premiumToppings);
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));

    }

}
