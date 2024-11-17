package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;

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
    // home screen
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

                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }
    // order screen
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

    // display sandwich custom options
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


    // user selects the size of bread
    private BreadType selectBreadType() {
        boolean isRunning = true;
        BreadType breadType = null;
        while (isRunning) {
            System.out.println("Select bread type: \n1) White \n2) Wheat \n3) Rye \n4) Wrap \n0) Exit");
            String breadChoice = scanner.nextLine();
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
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-4.");
                    continue;
            }
            System.out.println("You selected: " + breadType + " bread.");
            isRunning = false;
        }
        return breadType;
    }


    // user selects  size of sandwich
    private SandwichSize selectSandwichSize() {
        boolean isRunning = true;
        SandwichSize sandwichSize = null;
        while (isRunning) {
            System.out.println("Select sandwich size: \n1) Small (4 inches) \n2) Medium (8 inches) \n3) Large (12 inches) \n0) Exit");
            String sizeChoice = scanner.nextLine();
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
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-3");
            }
            System.out.println("You selected: " + sandwichSize + " size.");
            isRunning = false;
        }
        return sandwichSize;
    }


    // toppings screen
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
            PremiumToppings premiumToppings = null;
            RegularToppings regularToppings = null;
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
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-4");
                    return;

            }
        }
    }


    // user chooses regular toppings
    private RegularToppings regularToppingsDisplay() {
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
        return regularToppings;
    }

    private void premiumToppingsDisplay() {
        boolean isRunning = true;
        PremiumToppings premiumToppings = null;
        while (isRunning) {
            System.out.println("Please select which premium toppings you want \n 1) Meat toppings \n 2) Cheese toppings");
            String toppingChoice = scanner.nextLine();
            switch (toppingChoice) {
                case "1":
                    meatToppingsDisplay();
                    break;
                case "2":
                    cheeseToppingDisplay();
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-9.");
                    return;

            }
        }

    }


    private PremiumToppings meatToppingsDisplay() {
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
        return meatChoice;

    }

    private PremiumToppings cheeseToppingDisplay() {
        boolean isRunning = true;
        PremiumToppings cheeseChoice = null;
        while (isRunning) {
            System.out.println("Please choose a meat:\n 1) American cheese\n 2) Swiss cheese \n3) Provolone cheese \n4) Cheddar cheese\n0) None");
            String cheeseChosen = scanner.nextLine();
            switch (cheeseChosen) {
                case "1":
                    cheeseChoice = PremiumToppings.AMERICAN_CHEESE;
                    break;
                case "2":
                    cheeseChoice = PremiumToppings.SWISS_CHEESE;
                    break;
                case "3":
                    cheeseChoice = PremiumToppings.PROVOLONE_CHEESE;
                    break;
                case "4":
                    cheeseChoice = PremiumToppings.CHEDDAR_CHEESE;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-6");
                    continue;

            }

        }
        return cheeseChoice;
    }



    public void addExtraCheeseDisplay() {
        boolean isRunning = true;

        while (isRunning) {

        }
        // american provolone cheddar swiss

    }


    public void addExtraMeatDisplay() {
        boolean isRunning = true;
        while (isRunning) {

        }
        return;
    }

    // user chooses if they want the bread toasted
    private boolean selectToastedOption() {
        boolean isToasted = false;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Do you want your sandwich toasted? (Yes/No)");
            String toastChoice = scanner.nextLine().toLowerCase();
            if (toastChoice.equals("yes")) {
                isToasted = true;
                System.out.println("Sandwich will be toasted.");
                isRunning = false;
            } else if (toastChoice.equals("no")) {
                isToasted = false;
                System.out.println("Sandwich will not be toasted.");
                isRunning = false;
            } else {
                System.out.println("Invalid input. Please type 'Yes' or 'No'.");
            }
        }
        return isToasted;
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



    public void drinkDisplay() {
        boolean isRunning = true;
        String drinkChoice = null;
        while (isRunning) {
            System.out.println("Please choose drink size and flavor \n 1) Drink size \n 2) Drink flavor\n 0) Exit");
            drinkChoice = scanner.nextLine();
            switch (drinkChoice) {
                case "1":
                    drinkSizeDisplay();
                    break;
                case "2":
                    drinkFlavorDisplay();
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 1,2, or 0.");
                    return;
            }
        }
    }
    private void drinkSizeDisplay() {
        boolean isRunning = true;
        while (isRunning) {

        }
    }
    private void drinkFlavorDisplay () {
    }

    public ChipType chipsDisplay() {
        boolean isRunning = true;
        ChipType chipType = null;
        while (isRunning) {
            System.out.println("""
                    Please select the chips you would like.
                    1) Potato chips
                    2) BBQ chips
                    3) Sour cream and onion chips
                    4) Salt and vinegar chips
                    0) Exit
                    
                    """);
            String chipChoice = scanner.nextLine();
            switch (chipChoice) {
                case "1":
                    chipType = ChipType.POTATO_CHIPS;
                    break;
                case "2":
                    chipType = ChipType.BBQ;
                    break;
                case "3":
                    chipType = ChipType.SOUR_CREAM;
                    break;
                case "4":
                    chipType = ChipType.SALT_AND_VINEGAR;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1,2,3,4,0");
                    continue;
            }
        }
        return chipType;
    }

    public void checkOutDisplay() {
        boolean isRunning = true;
        while (isRunning) {
            // get users name

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


