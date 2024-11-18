package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class AddExtraCheeseScreen {
    static Scanner scanner = new Scanner(System.in);

    public static PremiumToppings addExtraCheeseDisplay() {

        boolean isRunning = true;
        PremiumToppings extraCheeseChoice = null;
        while (isRunning) {
            System.out.println("Please choose a meat:\n1) American cheese\n2) Swiss cheese \n3) Provolone cheese \n4) Cheddar cheese\n0) None");
            String cheeseChosen = scanner.nextLine();
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
                    System.out.println("Invalid choice. Please choose 0-6");
                    continue;

            }
            if (extraCheeseChoice != null) {
                System.out.println("You selected extra cheese: " + extraCheeseChoice);
                isRunning = false;
            } else {
                System.out.println("No extra cheese selected.");
                isRunning = false;

            }
        }
        return extraCheeseChoice;
    }
}
