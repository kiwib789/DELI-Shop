package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.RegularToppings;

import java.util.Scanner;

public class RegularToppingsScreen {
 Scanner scanner = new Scanner(System.in);

    public void regularToppingsDisplay() {
        boolean isRunning = true;
        RegularToppings regularToppings = null;
        while (isRunning) {
            System.out.println("Please select which regular toppings you want");
            String toppingChoice = scanner.nextLine();
            switch (toppingChoice) {
                case "1":
                    regularToppings = RegularToppings.LETTUCE;
                    break;
                case "2":
                    regularToppings = RegularToppings.PEPPERS;
                    break;
                case "3":
                    regularToppings = RegularToppings.ONIONS;
                    break;
                case "4":
                    regularToppings = RegularToppings.TOMATOES;
                    break;
                case "5":
                    regularToppings = RegularToppings.JALAPENOS;
                    break;
                case "6":
                    regularToppings = RegularToppings.CUCUMBERS;
                    break;
                case "7":
                    regularToppings = RegularToppings.PICKLES;
                    break;
                case "8":
                    regularToppings = RegularToppings.GUACAMOLE;
                    break;
                case "9":
                    regularToppings = RegularToppings.MUSHROOMS;
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-9.");


            }
        }
    }
}
