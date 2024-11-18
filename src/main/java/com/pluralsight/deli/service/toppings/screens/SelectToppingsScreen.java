package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;

import java.util.Scanner;

public class SelectToppingsScreen {
static Scanner scanner = new Scanner(System.in);
RegularToppingsScreen regularToppingsScreen = new RegularToppingsScreen();
AddExtraMeatScreen addExtraMeatScreen = new AddExtraMeatScreen();
AddExtraCheeseScreen addExtraCheeseScreen = new AddExtraCheeseScreen();
SaucesScreen saucesScreen = new SaucesScreen();
    public static PremiumToppings selectToppings() {
        boolean isRunning = true;
        PremiumToppings premiumToppings = null;
        while (isRunning) {
            System.out.println("""
                    Please choose the following options for your toppings:
                    1) Add regular toppings
                    2) Add premium toppings
                    3) Add extra meat
                    4) Add extra cheese
                    5) Sauces
                    0) Return to sandwich
                    """);
            String toppingChoice = scanner.nextLine();
            premiumToppings = null;
            RegularToppings regularToppings = null;
            switch (toppingChoice) {
                case "1":
                    RegularToppingsScreen.regularToppingsDisplay();
                    break;
                case "2":
                    PremiumToppingsScreen.premiumToppingsDisplay();
                    break;
                case "3":
                    AddExtraMeatScreen.addExtraMeatDisplay();
                    break;
                case "4":
                    AddExtraCheeseScreen.addExtraCheeseDisplay();
                    break;
                case "5":
                    SaucesScreen.addSaucesDisplay();
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-4");
                    continue;

            }

        }
        return premiumToppings;
    }

}
