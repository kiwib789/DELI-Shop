package com.pluralsight.deli.view;

import com.pluralsight.deli.enums.RegularToppings;

public class Prompts {
    static String homescreenPrompt = """
                    
                    Please choose your order.
                    
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order and return to home page
                    
                    """;

    static String regularToppingsPrompt = """
            Select your regular toppings:
            1) Lettuce
            2) Peppers
            3) Onions
            4) Tomatoes
            5) Jalapenos
            6) Cucumbers
            7) Pickles
            8) Guacamole
            9) Mushrooms
            
            Choose your option: """;

    static String premiumToppingsPrompt = """
            Select your premium toppings:
            1) Steak
            2) Ham
            3) Salami
            4) Roast beef
            5) Chicken
            6) Bacon
            7) American cheese
            8) Swiss cheese
            9) Provolone cheese
            10) Cheddar cheese
            
            Choose your option: """;
}

