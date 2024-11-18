package com.pluralsight.deli.service.drink.screens;

import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.service.HomeScreen;

import java.util.Scanner;

public class DrinkScreen extends HomeScreen {
    static Scanner scanner = new Scanner(System.in);
    DrinkSizeScreen drinkSizeScreen = new DrinkSizeScreen();
    DrinkFlavorScreen drinkFlavorScreen = new DrinkFlavorScreen();
    public static void drinkDisplay(Order order) {
        boolean isRunning = true;
        String drinkChoice = null;
        while (isRunning) {
            System.out.println("Please choose drink size and flavor \n 1) Drink size \n 2) Drink flavor\n 0) Exit");
            drinkChoice = scanner.nextLine();
            switch (drinkChoice) {
                case "1":
                    DrinkSizeScreen.drinkSizeDisplay(order);
                    break;
                case "2":
                    DrinkFlavorScreen.drinkFlavorDisplay(order);
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 1,2, or 0.");
                    return;
            }
        }
    }
}
