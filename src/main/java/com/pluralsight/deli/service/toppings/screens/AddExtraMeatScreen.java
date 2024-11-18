package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class AddExtraMeatScreen {
    static Scanner scanner = new Scanner(System.in);
    // method extra meat screen
    public static PremiumToppings addExtraMeatDisplay() {
        boolean isRunning = true;
        PremiumToppings extraMeatChoice = null;
        while (isRunning) {
            // allows user to select their choice of if they want extra meat and returns choice
            System.out.println(" Please choose extra meat toppings (will cost extra):\n1) Steak\n2) Ham \n3) Salami \n4) Roast beef \n5) Chicken \n6) Bacon \n0) None");
            String meatChosen = scanner.nextLine();
            switch (meatChosen) {
                case "1":
                    extraMeatChoice = PremiumToppings.STEAK;
                    break;
                case "2":
                    extraMeatChoice = PremiumToppings.HAM;
                    break;
                case "3":
                    extraMeatChoice = PremiumToppings.SALAMI;
                    break;
                case "4":
                    extraMeatChoice = PremiumToppings.ROAST_BEEF;
                case "5":
                    extraMeatChoice = PremiumToppings.CHICKEN;
                    break;
                case "6":
                    extraMeatChoice = PremiumToppings.BACON;
                    break;
                case "0":
                    // breaks out of loop
                    isRunning = false;
                    break;
                default:
                    // tells user if they entered the wrong choice
                    System.out.println("Invalid choice. Please choose 0-6");
                    continue;
            }
            // prints if they chose extra meat or not and what they chose if so
            if (extraMeatChoice != null) {
                System.out.println("You selected extra meat: " + extraMeatChoice);
                isRunning = false;
            } else {
                System.out.println("No extra meat selected.");
                isRunning = false;

            }

        }
        return extraMeatChoice;
    }
}

