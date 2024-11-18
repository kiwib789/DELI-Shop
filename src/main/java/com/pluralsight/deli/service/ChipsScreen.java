package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.ChipType;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Order;

import java.util.Scanner;

public class ChipsScreen {
    static Scanner scanner = new Scanner(System.in);

    public static Chips chipsDisplay(Order order) {
        boolean isRunning = true;
        Chips chips = null;
        while (isRunning) {
            System.out.println("""
                    Please select the chips you would like.
                    1) Potato chips
                    2) BBQ chips
                    3) Sour cream and onion chips
                    4) Salt and vinegar chips
                    0) Exit
                    
                    """);
            String chipChoice = scanner.nextLine();
            switch (chipChoice) {
                case "1":
                    chips = new Chips(ChipType.POTATO_CHIPS);
                    break;
                case "2":
                    chips = new Chips(ChipType.BBQ);
                    break;
                case "3":
                    chips = new Chips(ChipType.SOUR_CREAM);
                    break;
                case "4":
                    chips = new Chips(ChipType.SALT_AND_VINEGAR);
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1,2,3,4,0");
                    continue;
            }
            if (chips != null) {
                System.out.println("You selected: " + chips+ " chips.");
                isRunning = false;

            }

        }
        order.addProduct(chips);
        return chips;
    }
}
