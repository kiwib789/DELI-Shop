package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.service.drink.screens.DrinkScreen;
import com.pluralsight.deli.service.sandwich.screens.SandwichScreen;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);
    static SandwichScreen sandwichScreen = new SandwichScreen();
    DrinkScreen drinkScreen = new DrinkScreen();
    ChipsScreen chipsScreen = new ChipsScreen();
    CheckOutScreen checkOutScreen = new CheckOutScreen();

    public static void displayOrderScreen() {


        // home screen
        boolean isRunning = true;
        Sandwich sandwich = null;
        Drink drink = null;
        Chips chips = null;

        while (isRunning) {
            System.out.println("""
                    
                    Please choose your order.
                    
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order and return to home page
                    
                    """);
            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    System.out.println("Add a sandwich ");
                    sandwichScreen.addSandwichDisplay();
                    break;
                case "2":
                    System.out.println("Add a drink ");
                    DrinkScreen.drinkDisplay();
                    break;
                case "3":
                    System.out.println("Add chips ");
                    ChipsScreen.chipsDisplay();
                    break;
                case "4":
                    System.out.println("Proceed to checkout ");
                    CheckOutScreen.checkOutDisplay();
                    break;
                case "0":
                    System.out.println("Cancel order and return to home page ");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }
}
