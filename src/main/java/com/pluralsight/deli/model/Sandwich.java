package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.PremiumToppings;
import com.pluralsight.deli.enums.RegularToppings;
import com.pluralsight.deli.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product {
    private BreadType breadType;
    private SandwichSize size;
    private boolean isToasted;
    private final List<RegularToppings> regularToppings;
    private final List<PremiumToppings> premiumToppings;


     //constructor
    public Sandwich(String name, BreadType breadType, SandwichSize size, boolean isToasted) {
        super(name);
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

//    public Sandwich(String name, List<RegularToppings> regularToppings, List<PremiumToppings> premiumToppings, boolean isToasted, SandwichSize size, BreadType breadType) {
//        super(name);
//        this.regularToppings = regularToppings;
//        this.premiumToppings = premiumToppings;
//        this.isToasted = isToasted;
//        this.size = size;
//        this.breadType = breadType;
//    }

    // getters and setters
    public BreadType getBreadType() {
        return breadType;
    }

    //
    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<RegularToppings> getRegularToppings() {
        return regularToppings;
    }


    public List<PremiumToppings> getPremiumToppings() {
        return premiumToppings;
    }


    // Adds regular topping to the sandwich
    public void addRegularTopping(RegularToppings toppings) {

        regularToppings.add(toppings);
    }

    // Adds premium topping to the sandwich
    public void addPremiumTopping(PremiumToppings toppings) {

        premiumToppings.add(toppings);
    }


    /// total price
    @Override
    public double getPrice() {
        double total = 0.0;
        for (PremiumToppings topping : premiumToppings) {
            if (topping.getType() == PremiumToppings.Type.MEAT) {
                if (size == SandwichSize.SMALL) {
                    total += 1.00;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 2.00;
                } else if (size == SandwichSize.LARGE) {
                    total += 3.00;
                }

            } else if (topping.getType() == PremiumToppings.Type.CHEESE) {
                if (size == SandwichSize.SMALL) {
                    total += 0.75;
                } else if (size == SandwichSize.MEDIUM) {
                    total += 1.50;
                } else if (size == SandwichSize.LARGE) {
                    total += 2.25;
                }
            }
        }


        // Add the price for the bread type
        if (size == SandwichSize.SMALL) {
            total += 5.50;
        } else if (size == SandwichSize.MEDIUM) {
            total += 7.00;
        } else if (size == SandwichSize.LARGE) {
            total += 8.50;
        } else {
            throw new IllegalStateException("Unexpected value: " + breadType);
        }

        return total;
    }

    public String orderDetails() {

            StringBuilder details = new StringBuilder();

            details.append(name).append(" ")
                    .append(String.format("%.2f", getPrice()))  // price to 2 decimal places
                    .append("\nSize: ").append(size)
                    .append("\nBread type: ").append(breadType)
                    .append("\nToasted: ").append(isToasted ? "Yes" : "No")
                    .append("\nRegular toppings: ").append(regularToppings)
                    .append("\nPremium toppings: ").append(premiumToppings);
            // TODO extra cheese/meat toppings and sauces

            return details.toString();
        }

    @Override
    public String toString() {
        return "Sandwich{" +
                "premiumToppings=" + premiumToppings +
                ", breadType=" + breadType +
                ", size=" + size +
                ", isToasted=" + isToasted +
                ", regularToppings=" + regularToppings +
                '}';
    }
}





