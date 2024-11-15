package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderScreen{
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void displayOrderScreen(){



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
                    addSandwich();  // TODO create method
                    break;
                case "2":
                    System.out.println("Add a drink ");
                   addDrink();  //TODO create method
                    break;
                case "3":
                    System.out.println("Add chips ");
                  addChips(); // TODO create method
                    break;
                case "4":
                    System.out.println("Checkout ");
                     checkOutDisplay(); // TODO
                    break;
                case "0":
                    System.out.println("Cancel order and return to home page ");
                    isRunning = false;
                    break;
                // runs exit class
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }

    private void addChips() {

    }

    private void addDrink() {

    }

    private void addSandwich() {


    }
}
//private void addSandwich(){
//    System.out.println("Please enter the sandwich type:");
//    Sandwich sandwichType = scanner.nextLine();
//    Sandwich.append("Sandwich: ").append(sandwichType).append("\n");
//    System.out.println("Added sandwich: " + sandwichType);


