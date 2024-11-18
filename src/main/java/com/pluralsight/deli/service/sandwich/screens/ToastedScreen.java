package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class ToastedScreen {
    static Scanner scanner = new Scanner(System.in);
    // allows user to select if they want their sandwich toasted or not and returns choice
    public static boolean selectToastedOption(Order order) {
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
}
