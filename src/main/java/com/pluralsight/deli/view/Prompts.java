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
            0) Exit
            
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
            0) Exit
            
            Choose your option: """;

    static String chipsPrompt = """
            Please select the chips you would like.
            1) Potato chips
            2) BBQ chips
            3) Sour cream and onion chips
            4) Salt and vinegar chips
            0) Exit
            
            """;

    static String drinksSizePrompt = """
            Please choose drink size
            1) Small
            2) Medium
            3) Large
            0) Exit
            """;


    static String saucesPrompt = """
            Please choose sauces you would like
            1) Mayonnaise
            2) Mustard
            3) Ketchup
            4) Ranch 
            5) Thousand Island
            6) Vinaigrette
            0) Exit
            """;
    static String extraCheesePrompt = """
            Would you like extra cheese on your sandwich?
            1) American cheese
            2) Swiss cheese
            3) Provolone cheese
            4) Cheddar cheese
            0) No
            
            """;
    static String extraMeatPrompt = """
            Would you like extra meat on your sandwich?
            1) Steak
            2) Ham
            3) Salami
            4) Roast beef
            5) Chicken
            6) Bacon
            0) No
            """;

    static String isToastedPrompt = """
            Do you want your sandwich toasted?
            1) Yes
            2) No 
          
            """;
}

