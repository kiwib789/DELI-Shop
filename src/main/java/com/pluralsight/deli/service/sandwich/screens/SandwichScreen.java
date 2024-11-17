package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.service.toppings.screens.SelectToppingsScreen;

import java.util.Scanner;

public class SandwichScreen {
    static Scanner scanner = new Scanner(System.in);
    SelectBreadTypeScreen selectBreadType = new SelectBreadTypeScreen();
    SelectSandwichSizeScreen selectSandwichSize = new SelectSandwichSizeScreen();
    SelectToppingsScreen selectToppingsScreen = new SelectToppingsScreen();
    ToastedScreen toastedScreen = new ToastedScreen();
    CustomizationScreen customizationScreen = new CustomizationScreen();

    public static void addSandwichDisplay() {
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
                    SelectBreadTypeScreen.selectBreadType();
                    break;

                case "2":
                    SelectSandwichSizeScreen.selectSandwichSize();
                    break;

                case "3":
                    //  Regular + Premium
                    SelectToppingsScreen.selectToppings();
                    break;

                case "4":

                    ToastedScreen.selectToastedOption();
                    break;

                case "0":
                    CustomizationScreen.finishCustomization(null, null, null, null, isToasted);
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose a valid option.");
                    break;
            }
        }
    }
}
