package com.pluralsight.deli.view;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.service.SandwichService;
import com.pluralsight.deli.service.SandwichServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private final SandwichService sandwichService;
    private Order order;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public UserInterface() {
        this.sandwichService = new SandwichServiceImpl();
    }

    // home screen
    public void displayHomeScreen() {

        Scanner scanner = new Scanner(System.in);

        // home screen
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    
                    Welcome to the Deli Shop Home Screen!
                    
                    Please choose one of the following:
                    
                    1. New Order
                    0. Exit
                    """);
            String userInput = scanner.nextLine().toUpperCase();

            // Works with user input based on which answer they pick and takes them to the next screen
            switch (userInput) {
                case "1":
                    displayOrderScreen();
                    break;

                case "0":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }

    // order screen
    public void displayOrderScreen() {


        // home screen
        boolean isRunning = true;
        Sandwich sandwich = null;
        Drink drink = null;
        Chips chips = null;

        while (isRunning) {
            System.out.println(Prompts.homescreenPrompt);
            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                    System.out.println("Add a sandwich ");
                    addSandwichDisplay();
                    break;
                case "2":
                    System.out.println("Add a drink ");
                    drinkDisplay();
                    break;
                case "3":
                    System.out.println("Add chips ");
                    chipsDisplay();
                    break;
                case "4":
                    System.out.println("Proceed to checkout ");
                    checkOutDisplay();
                    break;
                case "0":
                    System.out.println("Cancel order and return to home page ");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input, please choose correct input.");
                    break;
            }
        }
    }

    // display sandwich custom options
    public void addSandwichDisplay() {

        boolean isSignature = selectSignatureOption();
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        boolean isToasted = selectToastedOption();
        Sandwich sandwich = sandwichService.createSandwich("Custom Sandwich", breadType, sandwichSize, isToasted);
        selectPremiumToppings(sandwich);
        selectRegularToppings(sandwich);

    }

    private void selectRegularToppings(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.regularToppingsPrompt);
            String toppingChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (toppingChoice.equals("0")) {
                isRunning = false;
            }
            RegularToppings topping = switch (toppingChoice) {
                case "1" -> RegularToppings.LETTUCE;
                case "2" -> RegularToppings.PEPPERS;
                case "3" -> RegularToppings.ONIONS;
                case "4" -> RegularToppings.TOMATOES;
                case "5" -> RegularToppings.JALAPENOS;
                case "6" -> RegularToppings.CUCUMBERS;
                case "7" -> RegularToppings.PICKLES;
                case "8" -> RegularToppings.GUACAMOLE;
                case "9" -> RegularToppings.MUSHROOMS;

                default -> {
                    System.out.println("Invalid input, try again");
                    yield null;
                }
            };
            if (topping != null) {
                sandwich.addRegularTopping(topping);
            }
        }
    }

    private void selectPremiumToppings(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.premiumToppingsPrompt);
            String toppingChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (toppingChoice.equals("0")) {
                isRunning = false;
            }
            PremiumToppings topping = switch (toppingChoice) {
                case "1" -> PremiumToppings.STEAK;
                case "2" -> PremiumToppings.HAM;
                case "3" -> PremiumToppings.SALAMI;
                case "4" -> PremiumToppings.ROAST_BEEF;
                case "5" -> PremiumToppings.CHICKEN;
                case "6" -> PremiumToppings.BACON;
                case "7" -> PremiumToppings.AMERICAN_CHEESE;
                case "8" -> PremiumToppings.SWISS_CHEESE;
                case "9" -> PremiumToppings.PROVOLONE_CHEESE;
                case "10" -> PremiumToppings.CHEDDAR_CHEESE;

                default -> {
                    System.out.println("Invalid input, try again");
                    yield null;
                }
            };
            if (topping != null) {
                sandwich.addPremiumTopping(topping);
            }

        }

    }
    // user selects the size of bread
    private BreadType selectBreadType() {
        boolean isRunning = true;
        BreadType breadType = null;
        while (isRunning) {
            System.out.println("Select bread type: \n1) White \n2) Wheat \n3) Rye \n4) Wrap \n0) Exit");
            String breadChoice = scanner.nextLine();
            switch (breadChoice) {
                case "1":
                    breadType = BreadType.WHITE;
                    break;
                case "2":
                    breadType = BreadType.WHEAT;
                    break;
                case "3":
                    breadType = BreadType.RYE;
                    break;
                case "4":
                    breadType = BreadType.WRAP;
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 0-4.");
                    continue;
            }
            System.out.println("You selected: " + breadType + " bread.");
            isRunning = false;
        }
        return breadType;
    }


    // user selects  size of sandwich
    private SandwichSize selectSandwichSize() {
        boolean isRunning = true;
        SandwichSize sandwichSize = null;
        while (isRunning) {
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
        return sandwichSize;
    }


    private void addSaucesDisplay() {

    }


    public void addExtraCheeseDisplay() {
        boolean isRunning = true;

        while (isRunning) {

        }
        // american provolone cheddar swiss

    }


    public void addExtraMeatDisplay() {
        boolean isRunning = true;
        while (isRunning) {

        }
        return;
    }

    private boolean selectSignatureOption() {
        return false;
    }

    // user chooses if they want the bread toasted
    private boolean selectToastedOption() {
        boolean isToasted = false;
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Do you want your sandwich toasted?\n1:Yes\n2:No\n");
            String toastChoice = scanner.nextLine();
            if (toastChoice.equals("1")) {
                isToasted = true;
                System.out.println("Sandwich will be toasted.");
                isRunning = false;
            } else if (toastChoice.equals("2")) {
                isToasted = false;
                System.out.println("Sandwich will not be toasted.");
                isRunning = false;
            } else {
                System.out.println("Invalid input. Please type '1' or '2'.");
            }
        }
        return isToasted;
    }

    public void drinkDisplay() {
        boolean isRunning = true;
        String drinkChoice = null;
        while (isRunning) {
            System.out.println("Please choose drink size and flavor \n 1) Drink size \n 2) Drink flavor\n 0) Exit");
            drinkChoice = scanner.nextLine();
            switch (drinkChoice) {
                case "1":
                    drinkSizeDisplay();
                    break;
                case "2":
                    drinkFlavorDisplay();
                    break;
                case "0":
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please choose 1,2, or 0.");
                    return;
            }
        }
    }

    private void drinkSizeDisplay() {
        boolean isRunning = true;
        while (isRunning) {

        }
    }

    private void drinkFlavorDisplay() {
    }

    public ChipType chipsDisplay() {
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
        }
        return chipType;
    }

    public void checkOutDisplay() {
        boolean isRunning = true;
        while (isRunning) {
            // get users name

        }
    }


    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }
}


