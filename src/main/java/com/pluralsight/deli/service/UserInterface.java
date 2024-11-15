package com.pluralsight.deli.service;

import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.PremiumToppings;
import com.pluralsight.deli.model.enums.RegularToppings;
import com.pluralsight.deli.model.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Order order;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public UserInterface(Order order) {
        this.order = order;
    }

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

    public void displayOrderScreen() {


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
                    addSandwichDisplay();
                    break;
                case "2":
                    System.out.println("Add a drink ");
                    drinkDisplay();
                    break;
                case "3":
                    System.out.println("Add chips ");
                    chipsDisplay();
                    break;
                case "4":
                    System.out.println("Proceed to checkout ");
                    checkOutDisplay();
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

    // Method to display sandwich custom options
    public void addSandwichDisplay() {
        boolean isRunning = true;

        BreadType breadType = null;
        SandwichSize sandwichSize = null;
        RegularToppings regularToppings = null;
        PremiumToppings premiumToppings = null;
        boolean isToasted = false;

        while (isRunning) {
            System.out.println("""
                    Option to customize your sandwich.
                    1) Select your bread type
                    2) Select sandwich size
                    3) Select toppings
                    4) Select if you want the sandwich toasted
                    0) Finish customizing and return to order screen
                    """);

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    selectBreadType();
                    break;

                case "2":
                    selectSandwichSize();
                    break;

                case "3":
                    //  Regular + Premium
                    selectToppings();
                    break;

                case "4":

                    selectToastedOption();
                    break;

                case "0":
                    finishCustomization(null, null, null, null, isToasted);
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose a valid option.");
                    break;
            }
        }
    }

    private void selectBreadType() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Select bread type: \n1) White \n2) Wheat \n3) Rye \n4) Wrap");
            String breadChoice = scanner.nextLine();
            BreadType breadType;
            switch (breadChoice) {
                case "1":
                    breadType = BreadType.WHITE;
                    break;
                case "2":
                    breadType = BreadType.WHEAT;
                    break;
                case "3":
                    breadType = BreadType.RYE;
                    break;
                case "4":
                    breadType = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, 3, or 4.");
                    return;
            }
            System.out.println("You selected: " + breadType + " bread.");
        }
    }

    private void selectSandwichSize() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Select sandwich size: \n1) Small (4 inches) \n2) Medium (8 inches) \n3) Large (12 inches)");
            String sizeChoice = scanner.nextLine();
            SandwichSize sandwichSize;
            switch (sizeChoice) {
                case "1":
                    sandwichSize = SandwichSize.SMALL;
                    break;
                case "2":
                    sandwichSize = SandwichSize.MEDIUM;
                    break;
                case "3":
                    sandwichSize = SandwichSize.LARGE;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    return;
            }
            System.out.println("You selected: " + sandwichSize + " size.");
        }
    }

    private void selectToppings() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    Please choose the following options for your toppings:
                    1) Add regular toppings
                    2) Add premium toppings
                    3) Add extra meat
                    4) Add extra cheese
                    0) Return to sandwich
                    """);
            String toppingChoice = scanner.nextLine();
            PremiumToppings premiumToppings;
            RegularToppings regularToppings;
            switch (toppingChoice) {
                case "1":
                    regularToppingsDisplay();
                    break;
                case "2":
                    premiumToppingsDisplay();
                    break;
                case "3":
                    addExtraMeatDisplay();
                    break;
                case "4":
                    addExtraCheeseDisplay();
                    break;
                case "0":
                    break;


            }
        }
    }


    private void selectToastedOption() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Do you want your sandwich toasted? (Yes/No)");
            String toastChoice = scanner.nextLine().toLowerCase();
            boolean isToasted;
            if (toastChoice.equals("yes")) {
                isToasted = true;
                System.out.println("Sandwich will be toasted.");
            } else if (toastChoice.equals("no")) {
                isToasted = false;
                System.out.println("Sandwich will not be toasted.");
            } else {
                System.out.println("Invalid input. Please type 'Yes' or 'No'.");
            }
        }
    }

    private void finishCustomization(BreadType breadType, SandwichSize sandwichSize, RegularToppings regularToppings,
                                     PremiumToppings premiumToppings, boolean isToasted) {
        System.out.println("Your custom sandwich is complete.");
        System.out.println("Description: ");
        System.out.println("Bread Type: " + breadType);
        System.out.println("Sandwich Size: " + sandwichSize);
        System.out.println("Regular Toppings: " + regularToppings);
        System.out.println("Premium Toppings: " + premiumToppings);
        System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));

    }

    private void regularToppingsDisplay() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Please select which regular toppings you want");
            String toppingChoice = scanner.nextLine();
            RegularToppings regularToppings;
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
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, 3, or 4.");
                    return;

            }
        }
    }
        private void premiumToppingsDisplay() {
            System.out.println("Please select which premium toppings you want \n 1) Meat toppings \n 2) Cheese toppings");
            String toppingChoice = scanner.nextLine();
            PremiumToppings premiumToppings;
            switch (toppingChoice) {
                case "1" :
                    meatToppingsDisplay();
                    break;
                case "2":
                    cheeseToppingDisplay();
                    break;

            }
        }

        public void drinkDisplay () {
            // add drink size
            // add drink flavor
        }

        public void chipsDisplay () {
            System.out.println("""
                    Please select the chips you would like.
                    """);
        }

        public void checkOutDisplay () {
            // get users name

        }
        public void addExtraCheeseDisplay() {
            // american provolone cheddar swiss

        }
        public void addExtraMeatDisplay() {

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


