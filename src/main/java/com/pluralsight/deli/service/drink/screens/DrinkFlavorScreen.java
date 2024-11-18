package com.pluralsight.deli.service.drink.screens;

import com.pluralsight.deli.model.Drink;

import java.util.Scanner;

public class DrinkFlavorScreen {
    static Scanner scanner = new Scanner(System.in);

    public static Drink.DrinkType drinkFlavorDisplay() {
        boolean isRunning = true;
        Drink.DrinkType drinkType = null;
        while (isRunning) {
            System.out.println("Please choose a drink flavor :\n 1) Sweet tea \n 2) Cola \n0) None");
            String flavorChosen = scanner.nextLine();
            switch (flavorChosen) {
                case "1":
                    drinkType = Drink.DrinkType.TEA;
                    break;
                case "2":
                    drinkType = Drink.DrinkType.COLA;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 0-2");
                    continue;

            }
            if (drinkType != null) {
                System.out.println("You selected: " + drinkType + " bread.");
                isRunning = false;
            }
        }
        return drinkType;
    }
}