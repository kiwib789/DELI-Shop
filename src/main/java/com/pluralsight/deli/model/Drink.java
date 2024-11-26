package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.DrinkSize;


public class Drink extends Product {

    private final DrinkSize size;

    // constructor


    public Drink(String name, DrinkSize size) {
        super(name);
        this.size = size;
    }

    // getters
    public DrinkSize getSize() {

        return size;
    }




    @Override
    public double getPrice(){
        return 0.0;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}

