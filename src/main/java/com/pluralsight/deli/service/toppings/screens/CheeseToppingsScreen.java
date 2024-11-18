package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class CheeseToppingsScreen {
    static Scanner scanner = new Scanner(System.in);

    public static PremiumToppings cheeseToppingDisplay() {
        boolean isRunning = true;
        PremiumToppings cheeseChoice = null;
        while (isRunning) {
            System.out.println("Please choose a meat:\n1) American cheese\n2) Swiss cheese \n3) Provolone cheese \n4) Cheddar cheese\n0) None");
            String cheeseChosen = scanner.nextLine();
            switch (cheeseChosen) {
                case "1":
                    cheeseChoice = PremiumToppings.AMERICAN_CHEESE;
                    break;
                case "2":
                    cheeseChoice = PremiumToppings.SWISS_CHEESE;
                    break;
                case "3":
                    cheeseChoice = PremiumToppings.PROVOLONE_CHEESE;
                    break;
                case "4":
                    cheeseChoice = PremiumToppings.CHEDDAR_CHEESE;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-6");
                    continue;

            }
            if (cheeseChoice != null) {
                System.out.println("You selected: " + cheeseChoice + " topping.");
                isRunning = false;
            }
        }
        return cheeseChoice;
    }
}
