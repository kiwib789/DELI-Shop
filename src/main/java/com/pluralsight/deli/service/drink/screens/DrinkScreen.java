package com.pluralsight.deli.service.drink.screens;

import java.util.Scanner;

public class DrinkScreen {
    static Scanner scanner = new Scanner(System.in);
    DrinkSizeScreen drinkSizeScreen = new DrinkSizeScreen();
    DrinkFlavorScreen drinkFlavorScreen = new DrinkFlavorScreen();
    public static void drinkDisplay() {
        boolean isRunning = true;
        String drinkChoice = null;
        while (isRunning) {
            System.out.println("Please choose drink size and flavor \n 1) Drink size \n 2) Drink flavor\n 0) Exit");
            drinkChoice = scanner.nextLine();
            switch (drinkChoice) {
                case "1":
                    DrinkSizeScreen.drinkSizeDisplay();
                    break;
                case "2":
                    DrinkFlavorScreen.drinkFlavorDisplay();
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
