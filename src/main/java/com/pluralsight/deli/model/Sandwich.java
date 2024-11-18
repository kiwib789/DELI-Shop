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
    private boolean extraMeat;
    private boolean extraCheese;
    private final List<RegularToppings> regularToppings;
    private final List<PremiumToppings> premiumToppings;


    // constructor
    public Sandwich(Sandwich sandwich, BreadType breadType, SandwichSize size, boolean isToasted) {
        super(sandwich.name);
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

    // getters and setters
    public BreadType getBreadType() {
        return breadType;
    }

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

        // Add the price for the bread type based on size
        if (size == SandwichSize.SMALL) {
            total += 5.50;
        } else if (size == SandwichSize.MEDIUM) {
            total += 7.00;
        } else if (size == SandwichSize.LARGE) {
            total += 8.50;
        } else {
            throw new IllegalStateException("Unexpected sandwich size: " + size);
        }

        // Add the price for the premium toppings
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

        // Add extra meat price
        if (extraMeat) {
            if (size == SandwichSize.SMALL) {
                total += 0.50;
            } else if (size == SandwichSize.MEDIUM) {
                total += 1.00;
            } else if (size == SandwichSize.LARGE) {
                total += 1.50;
            }
        }

        // Add extra cheese price
        if (extraCheese) {
            if (size == SandwichSize.SMALL) {
                total += 0.30;
            } else if (size == SandwichSize.MEDIUM) {
                total += 0.60;
            } else if (size == SandwichSize.LARGE) {
                total += 0.90;
            }
        }

        return total;  // return the total
    }


    public void setExtraMeat (boolean extraMeat){
            this.extraMeat = extraMeat;
        }

        public boolean isExtraCheese () {
            return extraCheese;
        }

        public void setExtraCheese ( boolean extraCheese){
            this.extraCheese = extraCheese;
        }
    }
