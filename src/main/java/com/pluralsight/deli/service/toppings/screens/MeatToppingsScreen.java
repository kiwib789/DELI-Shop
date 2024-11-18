package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class MeatToppingsScreen {
    static Scanner scanner = new Scanner(System.in);
    public static void meatToppingsDisplay() {
        boolean isRunning = true;
        PremiumToppings meatChoice = null;
        while (isRunning) {
            System.out.println(" Please choose a meat:\n 1) Steak\n 2) Ham \n3) Salami \n4) Roast beef \n5) Chicken \n6) Bacon \n0) None");
            String meatChosen = scanner.nextLine();
            switch (meatChosen) {
                case "1":
                    meatChoice = PremiumToppings.STEAK;
                    break;
                case "2":
                    meatChoice = PremiumToppings.HAM;
                    break;
                case "3":
                    meatChoice = PremiumToppings.SALAMI;
                    break;
                case "4":
                    meatChoice = PremiumToppings.ROAST_BEEF;
                case "5":
                    meatChoice = PremiumToppings.CHICKEN;
                    break;
                case "6":
                    meatChoice = PremiumToppings.BACON;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-6");
                    continue;
            }

        }

    }
}
