package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.Sauces;
import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class SaucesScreen {
    static Scanner scanner = new Scanner(System.in);
    // method for adding sauces screen
    public static Sauces addSaucesDisplay() {
        boolean isRunning = true;
        Sauces sauceChoice = null;
        while (isRunning) {
            System.out.println("Please choose sauces:\n 1) Mayo\n 2) Mustard \n3) Ketchup \n4) Ranch \n5) Thousand island \n6) Vinaigrette \n7) Au jus\n0) None");
            String sauceChosen = scanner.nextLine();
            switch (sauceChosen) {
                case "1":
                    sauceChoice = Sauces.MAYO;
                    break;
                case "2":
                    sauceChoice = Sauces.MUSTARD;
                    break;
                case "3":
                    sauceChoice = Sauces.KETCHUP;
                    break;
                case "4":
                    sauceChoice = Sauces.RANCH;
                case "5":
                    sauceChoice = Sauces.THOUSAND_ISLAND;
                    break;
                case "6":
                    sauceChoice = Sauces.VINAIGRETTE;
                    break;
                case "7":
                    sauceChoice = Sauces.AU_JUS;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-7");
                    continue;

            }
            if (sauceChoice != null) {
                System.out.println("You selected: " + sauceChoice);
                isRunning = false;

            }
        }
        return sauceChoice;
    }
}



