package com.pluralsight.deli.model;

import jdk.internal.icu.text.UnicodeSet;

public class Drink extends Product {

    private final DrinkType type;
    private final DrinkSize size;

    // constructor
    public Drink(DrinkSize drinkSize, DrinkType drinkType) {
        super(drinkType.name());
        this.size = drinkSize;
        this.type = drinkType;

    }

    // getters
    public DrinkSize getSize() {

        return size;
    }


    public DrinkType getType() {

        return type;
    }

    public enum DrinkSize {
        SMALL("Small", 2.00),
        MEDIUM("Medium", 2.50),
        LARGE("Large", 3.00);

        private final String description;
        private final double price;

        DrinkSize(String description, double price) {
            this.description = description;
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }
    }

    public enum DrinkType {
        // tea soda water

        TEA("Sweet Tea"),
        COLA("Coca-cola");

        private final String description;

        DrinkType(String description) {
            this.description = description;
        }
    }

    public double getPrice() {
        if (size == DrinkSize.SMALL) {
            return DrinkSize.SMALL.price;
        } else if (size == DrinkSize.MEDIUM) {
            return DrinkSize.MEDIUM.price;
        } else {
            return DrinkSize.LARGE.price;
        }
    }


    @Override
    public String toString() {
        return "Drink{" +
                "type: " + type.description +
                ", size: " + size.description +
                ", price: =" + size.price +
                '}';
    }
}

