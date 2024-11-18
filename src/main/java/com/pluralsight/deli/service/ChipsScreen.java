package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.ChipType;

import java.util.Scanner;

public class ChipsScreen {
    static Scanner scanner = new Scanner(System.in);

    public static ChipType chipsDisplay() {
        boolean isRunning = true;
        ChipType chipType = null;
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
                    chipType = ChipType.POTATO_CHIPS;
                    break;
                case "2":
                    chipType = ChipType.BBQ;
                    break;
                case "3":
                    chipType = ChipType.SOUR_CREAM;
                    break;
                case "4":
                    chipType = ChipType.SALT_AND_VINEGAR;
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1,2,3,4,0");
                    continue;
            }
            if (chipType != null) {
                System.out.println("You selected: " + chipType + " chips.");
                isRunning = false;

            }

        }
        return chipType;
    }
}
