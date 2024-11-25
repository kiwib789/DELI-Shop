package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;



import java.util.Scanner;

public class SelectToppingsScreen() {

    public static PremiumToppings selectToppings(Order order) {

        // Ask for regular toppings
        .RegularToppings = RegularToppings.regularToppingsDisplay(order);

        // Ask for premium toppings

        // Ask for extra meat

        // ask for extra cheese

        // ask for sauces

        // add drink to order
        order.addProduct();

    }
}


