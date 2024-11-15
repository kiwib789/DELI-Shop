package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class HomeScreen extends OrderScreen{

    public void displayHomeScreen() {

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
                   displayOrderScreen();
                    break;

                case "0":
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }

}