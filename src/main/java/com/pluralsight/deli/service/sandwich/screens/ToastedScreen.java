package com.pluralsight.deli.service.sandwich.screens;

import java.util.Scanner;

public class ToastedScreen {
    static Scanner scanner = new Scanner(System.in);

    public static boolean selectToastedOption() {
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
