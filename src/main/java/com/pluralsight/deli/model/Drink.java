package com.pluralsight.deli.model;

public class Drink extends Product{

    private final DrinkType type;
    private final DrinkSize size;

    public Drink(DrinkSize size, DrinkType type) {
        super(size.description);
        this.type = type;
        this.size = size;
    }

    public DrinkSize getSize() {
        return size;
    }


    public DrinkType getType() {
        return type;
    }

    public enum DrinkSize{
        SMALL("Small", 2.00),
        medium("Medium", 2.50),
        large("Large",3.00);

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

    public double getPrice(DrinkSize drinkSize) {
        if (drinkSize == DrinkSize.SMALL) {
            return DrinkSize.SMALL.price;
        } else if (drinkSize == DrinkSize.medium) {
            return DrinkSize.medium.price;
        } else {
            return DrinkSize.large.price;
        }
    }
    @Override
    public double getPrice() {

        return DrinkSize.SMALL.getPrice();
    }
    @Override
    public String toString() {
        return "Drink{" +
                "type=" + type.description +
                ", size=" + size.description +
                ", price=" + size.price +
                '}';
    }
}

