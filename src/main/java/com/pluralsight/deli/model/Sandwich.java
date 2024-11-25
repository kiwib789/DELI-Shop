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


    // constructor
    public Sandwich(Sandwich sandwich, BreadType breadType, SandwichSize size, boolean isToasted) {
        super(sandwich.name);
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

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


    // enums
    public enum SandwichSize {
        SMALL,
        MEDIUM,
        LARGE;
    }
    public enum BreadType{
        WHITE,
        WHEAT,
        RYE,
        WRAP;


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

        //enums


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

    @Override
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



    }





