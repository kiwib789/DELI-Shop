package com.pluralsight.deli.model;

import com.pluralsight.deli.enums.ChipType;

public class Chips extends Product {
    private ChipType chipType;


    // Constructor
    public Chips(ChipType chipType) {
        super(chipType.name());
        this.chipType = chipType;
    }



    // Price of chips
    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String productDetail() {
        StringBuilder details = new StringBuilder();

        details.append("\nChips: ").append(chipType);
        details.append("\nPrice: $").append(String.format("%.2f", getPrice()));
        return details.toString();
    }

    @Override
    public String toString() {
        return "Chips{" +
                "chipType: " + chipType +
                ", name: '" + name + '\'' +
                '}';
    }
}