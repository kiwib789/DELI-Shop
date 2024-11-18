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
}