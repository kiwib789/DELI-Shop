package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    Scanner scanner = new Scanner(System.in);
    private Order order;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    OrderScreen orderScreen = new OrderScreen();
    public void UserInterface(Order order) {
        this.order = order;
    }
    // home screen
    public static void displayHomeScreen() {

        Scanner scanner = new Scanner(System.in);

        // home screen
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    Welcome to the Deli Shop Home Screen!
                    
                    Please choose one of the following:
                    
                    1. New Order
                    0. Exit
                    """);
            String userInput = scanner.nextLine().toUpperCase();

            // Works with user input based on which answer they pick and takes them to the next screen
            switch (userInput) {
                case "1":
                    OrderScreen.displayOrderScreen();
                    break;

                case "0":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }
    public List<Sandwich> getSandwiches () {
        return sandwiches;
    }

    public void setSandwiches (List < Sandwich > sandwiches) {
        this.sandwiches = sandwiches;
    }

    public Order getOrder () {
        return order;
    }

    public void setOrder (Order order){
        this.order = order;
    }

    public List<Drink> getDrinks () {
        return drinks;
    }

    public void setDrinks (List < Drink > drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips () {
        return chips;
    }

    public void setChips (List < Chips > chips) {
        this.chips = chips;
    }
}

