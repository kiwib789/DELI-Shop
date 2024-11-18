package com.pluralsight.deli.service.toppings.screens;

import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.service.HomeScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegularToppingsScreen extends HomeScreen {
    static Scanner scanner = new Scanner(System.in);

    public static List<RegularToppings> regularToppingsDisplay() {
        boolean isRunning = true;
        List<RegularToppings> selectedToppings = new ArrayList<>();

        while (isRunning) {
            System.out.println("""
                Please select which regular toppings you want to add (multiple selections allowed):
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pickles
                8) Guacamole
                9) Mushrooms
                0) Done selecting
                """);

            String toppingChoice = scanner.nextLine();

            switch (toppingChoice) {
                case "1":
                    selectedToppings.add(RegularToppings.LETTUCE);
                    break;
                case "2":
                    selectedToppings.add(RegularToppings.PEPPERS);
                    break;
                case "3":
                    selectedToppings.add(RegularToppings.ONIONS);
                    break;
                case "4":
                    selectedToppings.add(RegularToppings.TOMATOES);
                    break;
                case "5":
                    selectedToppings.add(RegularToppings.JALAPENOS);
                    break;
                case "6":
                    selectedToppings.add(RegularToppings.CUCUMBERS);
                    break;
                case "7":
                    selectedToppings.add(RegularToppings.PICKLES);
                    break;
                case "8":
                    selectedToppings.add(RegularToppings.GUACAMOLE);
                    break;
                case "9":
                    selectedToppings.add(RegularToppings.MUSHROOMS);
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-9.");
                    continue;
            }

            if (!toppingChoice.equals("0")) {
                System.out.println("Would you like to add another topping? (yes/no)");
                String continueChoice = scanner.nextLine();
                if (continueChoice.equalsIgnoreCase("n")) {
                    isRunning = false;
                }
            }
        }

        if (selectedToppings.isEmpty()) {
            System.out.println("No regular toppings selected.");
        } else {
            System.out.println("You selected the following regular toppings:");
            for (RegularToppings topping : selectedToppings) {
                System.out.println(" " + topping);
            }
        }

        return selectedToppings;
    }
}
