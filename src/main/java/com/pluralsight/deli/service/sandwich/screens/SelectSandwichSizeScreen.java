package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class SelectSandwichSizeScreen {
    static Scanner scanner = new Scanner(System.in);

    public SandwichSize selectSandwichSize(Order order) {
        boolean isRunning = true;
        SandwichSize sandwichSize = null;
        while (isRunning) {
            // allows user to select their choice of sandwich size and returns choice
            System.out.println("Select sandwich size: \n1) Small (4 inches) \n2) Medium (8 inches) \n3) Large (12 inches) \n0) Exit");
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
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-3");
            }
            System.out.println("You selected: " + sandwichSize + " size.");
            isRunning = false;
        }
        //order.addProduct(sandwichSize);
        return sandwichSize;
    }


}
