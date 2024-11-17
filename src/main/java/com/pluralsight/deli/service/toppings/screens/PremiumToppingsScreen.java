package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.PremiumToppings;

import java.util.Scanner;

public class PremiumToppingsScreen {
    Scanner scanner = new Scanner(System.in);
    CheeseToppingsScreen cheeseToppingsScreen = new CheeseToppingsScreen();
    MeatToppingsScreen meatToppingsScreen = new MeatToppingsScreen();
    public void premiumToppingsDisplay() {
        boolean isRunning = true;
        PremiumToppings premiumToppings = null;
        while (isRunning) {
            System.out.println("Please select which premium toppings you want \n 1) Meat toppings \n 2) Cheese toppings");
            String toppingChoice = scanner.nextLine();
            switch (toppingChoice) {
                case "1":
                    MeatToppingsScreen.meatToppingsDisplay();
                    break;
                case "2":
                    CheeseToppingsScreen.cheeseToppingDisplay();
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-9.");
                    return;

            }
        }

    }
}
