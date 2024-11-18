package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.service.toppings.screens.SelectToppingsScreen;

import java.util.Scanner;

public class SandwichScreen {
    static Scanner scanner = new Scanner(System.in);
    static SelectBreadTypeScreen selectBreadType = new SelectBreadTypeScreen();
    SelectSandwichSizeScreen selectSandwichSize = new SelectSandwichSizeScreen();
    SelectToppingsScreen selectToppings = new SelectToppingsScreen();
    ToastedScreen toastedScreen = new ToastedScreen();
    CustomizationScreen customizationScreen = new CustomizationScreen();

    public void addSandwichDisplay(Order order) {
        boolean isRunning = true;

        BreadType breadType = null;
        SandwichSize sandwichSize = null;
        PremiumToppings regularToppings = null;
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

                    breadType = selectBreadType.selectBreadType(order);
                    break;

                case "2":
                    sandwichSize = selectSandwichSize.selectSandwichSize(order);
                    break;

                case "3":
                    //  Regular + Premium
                    premiumToppings = selectToppings.selectToppings(order);
                    regularToppings = selectToppings.selectToppings(order);
                    break;
                case "4":
                    ToastedScreen.selectToastedOption(order);
                    break;

                case "0":
                    CustomizationScreen.finishCustomization(breadType, sandwichSize, regularToppings, premiumToppings, isToasted);
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose a valid option.");
                    break;
            }
        }
    }
}
