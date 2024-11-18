package com.pluralsight.deli.service.drink.screens;

import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class DrinkSizeScreen {
    static Scanner scanner = new Scanner(System.in);

    public static Drink.DrinkSize drinkSizeDisplay(Order order) {
        boolean isRunning = true;
        Drink.DrinkSize selectDrinkSize = null;
        while (isRunning) {
            System.out.println("Select sandwich size: \n1) Small (4 inches) \n2) Medium (8 inches) \n3) Large (12 inches) \n0) Exit");
            String sizeChoice = scanner.nextLine();
            switch (sizeChoice) {
                case "1":
                    selectDrinkSize = Drink.DrinkSize.SMALL;
                    break;
                case "2":
                    selectDrinkSize = Drink.DrinkSize.MEDIUM;
                    break;
                case "3":
                    selectDrinkSize = Drink.DrinkSize.LARGE;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-3");
            }
            if (selectDrinkSize != null) {
                System.out.println("You selected: " + selectDrinkSize + " size.");
                isRunning = false;
            }
        }
        return selectDrinkSize;
    }
}




