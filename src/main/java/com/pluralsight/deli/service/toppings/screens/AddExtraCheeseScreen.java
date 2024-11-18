package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class AddExtraCheeseScreen {
    // scanner to read user input
    static Scanner scanner = new Scanner(System.in);
    // method to display extra cheese options
    public static PremiumToppings addExtraCheeseDisplay() {

        boolean isRunning = true;
        PremiumToppings extraCheeseChoice = null;
        while (isRunning) {
            // prompts user for their choice
            System.out.println("Please choose a meat:\n1) American cheese\n2) Swiss cheese \n3) Provolone cheese \n4) Cheddar cheese\n0) None");
            String cheeseChosen = scanner.nextLine();
            // sets users input
            switch (cheeseChosen) {
                case "1":
                    extraCheeseChoice = PremiumToppings.AMERICAN_CHEESE;
                    break;
                case "2":
                    extraCheeseChoice = PremiumToppings.SWISS_CHEESE;
                    break;
                case "3":
                    extraCheeseChoice = PremiumToppings.PROVOLONE_CHEESE;
                    break;
                case "4":
                    extraCheeseChoice = PremiumToppings.CHEDDAR_CHEESE;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-4");
                    continue;

            }
            // prints if they chose extra meat or not and what they chose if so
            if (extraCheeseChoice != null) {
                System.out.println("You selected extra cheese: " + extraCheeseChoice);
                isRunning = false;
            } else {
                System.out.println("No extra cheese selected.");
                isRunning = false;

            }
        }
        //returns users choice
        return extraCheeseChoice;
    }
}
