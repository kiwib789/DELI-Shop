package com.pluralsight.deli.service;

import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.PremiumToppings;
import com.pluralsight.deli.model.enums.RegularToppings;
import com.pluralsight.deli.model.enums.SandwichSize;

import java.util.Scanner;

public class AddSandwich{

    Scanner scanner = new Scanner(System.in);


    // Method to display sandwich custom options
    public void addSandwichDisplay() {
        boolean isRunning = true;

        // Variables to store the user's selections
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
                    // Select bread type
                    System.out.println("Select bread type: \n1) White \n2) Wheat \n3) Rye \n 4) Wrap");
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
                        default:
                            System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                            continue;
                    }
                    System.out.println("You selected: " + breadType + " bread.");
                    break;

                case "2":
                    // Sandwich size
                    System.out.println("Select sandwich size: \n1) Small (4 inches) \n2) Medium (8 inches) \n3) Large (12 inches)");
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
                        default:
                            System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                            continue;
                    }
                    System.out.println("You selected: " + sandwichSize + " size.");
                    break;

                case "3":
                    // Select toppings



                case "4":
                    // Select if the sandwich should be toasted
                    System.out.println("Do you want your sandwich toasted? (Yes/No)");
                    String toastChoice = scanner.nextLine().toLowerCase();
                    if (toastChoice.equals("yes")) {
                        isToasted = true;
                        System.out.println("Toasted ");
                    } else if (toastChoice.equals("no")) {
                        isToasted = false;
                        System.out.println("Not toasted ");
                    } else {
                        System.out.println("Invalid input. Please type 'Yes' or 'No'.");
                    }
                    break;

                case "0":
                    System.out.println("Your custom sandwich is complete.");
                    System.out.println("Description: ");
                    System.out.println("Bread Type: " + breadType);
                    System.out.println("Sandwich Size: " + sandwichSize);
                    System.out.println("Regular Toppings: " + regularToppings);
                    System.out.println("Premium Toppings: " + premiumToppings);
                    System.out.println("Toasted: " + (isToasted ? "Yes" : "No"));
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose a valid option.");
                    break;
            }
        }
    }

}

