package com.pluralsight.deli.view;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.service.OrderService;
import com.pluralsight.deli.service.OrderServiceImpl;
import com.pluralsight.deli.service.SandwichService;
import com.pluralsight.deli.service.SandwichServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private final SandwichService sandwichService;
    private final OrderService orderService;
    private Order order;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public UserInterface() {
        this.sandwichService = new SandwichServiceImpl();
        this.orderService = new OrderServiceImpl();
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
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Order order = orderService.createNewOrder(customerName);

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
                    addSandwichDisplay(order);
                    break;
                case "2":
                    System.out.println("Add a drink ");
                    selectDrink(order);
                    break;
                case "3":
                    System.out.println("Add chips ");
                    chipsDisplay(order);
                    break;
                case "4":
                    System.out.println("Proceed to checkout ");
                    orderService.checkOut(order);
                    //checkOutDisplay(order);
                    isRunning = false;
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
    public void addSandwichDisplay(Order order) {

        boolean isSignature = selectSignatureOption();
        BreadType breadType = selectBreadType();
        SandwichSize sandwichSize = selectSandwichSize();
        boolean isToasted = selectToastedOption();
        Sandwich sandwich = sandwichService.createSandwich("Custom Sandwich", breadType, sandwichSize, isToasted);
        selectPremiumToppings(sandwich);
        selectRegularToppings(sandwich);
        addExtraCheeseDisplay(sandwich);
        sandwich.setExtraMeat(addExtraMeatDisplay(sandwich));
        selectSauces(sandwich);
        orderService.addProductToOrder(order, sandwich);

    }

    private void selectRegularToppings(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.regularToppingsPrompt);
            String toppingChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (toppingChoice.equals("0")) {
                isRunning = false;
            } else {
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
                    System.out.println("You selected: " + topping + " regular toppings.");
                }
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
            } else {
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
                    System.out.println("You selected: " + topping + " premium toppings.");
                }
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


    public void addExtraCheeseDisplay(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.extraCheesePrompt);
            String toppingChoice = scanner.nextLine();
            if (toppingChoice.equals("0")) {
                isRunning = false;
            } else {
                PremiumToppings topping = switch (toppingChoice) {
                    case "1" -> PremiumToppings.AMERICAN_CHEESE;
                    case "2" -> PremiumToppings.SWISS_CHEESE;
                    case "3" -> PremiumToppings.PROVOLONE_CHEESE;
                    case "4" -> PremiumToppings.CHEDDAR_CHEESE;

                    default -> {
                        System.out.println("Invalid input, try again");
                        yield null;
                    }
                };
                if (topping != null) {
                    sandwich.addPremiumTopping(topping);
                    System.out.println("You selected: " + topping + "  extra cheese.");
                    isRunning = false;

                }
            }

        }
    }


    public boolean addExtraMeatDisplay(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.extraMeatPrompt);
            String hasExtraMeat = scanner.nextLine();
            if (hasExtraMeat.equals("0")) {
                isRunning = false;
            } else {
                PremiumToppings toppings = switch (hasExtraMeat) {
                    case "1" -> PremiumToppings.STEAK;
                    case "2" -> PremiumToppings.HAM;
                    case "3" -> PremiumToppings.SALAMI;
                    case "4" -> PremiumToppings.ROAST_BEEF;
                    case "5" -> PremiumToppings.CHICKEN;
                    case "6" -> PremiumToppings.BACON;


                    default -> {
                        System.out.println("Invalid input, try again");
                        yield null;
                    }
                };
                if (toppings != null) {
                    sandwich.addPremiumTopping(toppings);
                    System.out.println("You selected: " + toppings + "  extra meat.");
                    isRunning = false;

                }
            }
        }
        return true;
    }

    private boolean selectSignatureOption() {
        return false;
    }


    // user chooses if they want the bread toasted
    private boolean selectToastedOption() {
        boolean isToasted = false;
        boolean isRunning = true;
        String toastChoice;
        while (isRunning) {
            System.out.println(Prompts.isToastedPrompt);
            toastChoice = scanner.nextLine();
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

    public void selectDrink(Order order) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.drinksSizePrompt);
            String drinkSizeChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (drinkSizeChoice.equals("0")) {
                isRunning = false;
            } else {
                DrinkSize drinkSize = switch (drinkSizeChoice) {
                    case "1" -> DrinkSize.SMALL;
                    case "2" -> DrinkSize.MEDIUM;
                    case "3" -> DrinkSize.LARGE;

                    default -> {
                        System.out.println("Invalid input, try again");
                        yield null;
                    }

                };
                if (drinkSize != null) {
                    orderService.addProductToOrder(order, new Drink("Drink", drinkSize));
                    System.out.println("You selected: " + drinkSize + " drink.");
                    isRunning = false;
                }
            }
        }
    }

    public void chipsDisplay(Order order) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.chipsPrompt);
            String chipChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (chipChoice.equals("0")) {
                isRunning = false;
            } else {
                ChipType chips = switch (chipChoice) {
                    case "1" -> ChipType.POTATO_CHIPS;
                    case "2" -> ChipType.BBQ;
                    case "3" -> ChipType.SOUR_CREAM;
                    case "4" -> ChipType.SALT_AND_VINEGAR;

                    default -> {
                        System.out.println("Invalid input, try again");
                        yield null;
                    }
                };
                if (chips != null) {
                    orderService.addProductToOrder(order, new Chips(chips));
                    System.out.println("You selected: " + chips + " chips.");
                    isRunning = false;
                }
            }
        }

    }

    private void selectSauces(Sandwich sandwich) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(Prompts.saucesPrompt);
            String saucesChoice = scanner.nextLine();
            // if the topping choice == 0 isrunning is false
            if (saucesChoice.equals("0")) {
                isRunning = false;
            } else {
                Sauces sauces = switch (saucesChoice) {
                    case "1" -> Sauces.MAYO;
                    case "2" -> Sauces.MUSTARD;
                    case "3" -> Sauces.KETCHUP;
                    case "4" -> Sauces.RANCH;
                    case "5" -> Sauces.THOUSAND_ISLAND;
                    case "6" -> Sauces.VINAIGRETTE;


                    default -> {
                        System.out.println("Invalid input, try again");
                        yield null;
                    }
                };
                if (sauces != null) {
                    sandwich.addSauce(sauces);
                    System.out.println("You selected: " + sauces + " sauces.");
                }

            }
        }

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}


