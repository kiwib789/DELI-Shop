package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.DrinkSize;


public class Drink extends Product {

    private final DrinkSize size;

    // constructor
    public Drink(String name, DrinkSize size) {
        super(name);
        this.size = size;
    }

    // getter
    public DrinkSize getSize() {

        return size;
    }

   // price method
    @Override
    public double getPrice() {
        double total = 0.0;

        if (size == DrinkSize.SMALL) {
            total += 2.00;
        } else if (size == DrinkSize.MEDIUM) {
            total += 2.50;
        } else if (size == DrinkSize.LARGE) {
            total += 3.00;
        }
    return total;

    }



    @Override
            public String toString () {
                return "Drink{" +
                        "name: " + name + '\'' +
                        ", size: " + size +
                        '}';
            }
        }



