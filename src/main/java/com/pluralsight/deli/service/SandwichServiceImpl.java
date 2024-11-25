package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Sandwich;

public class SandwichServiceImpl implements SandwichService {

    @Override
    public Sandwich createSandwich(String name, BreadType breadType, SandwichSize size, boolean isToasted){
        //Create a sandwich
        return new Sandwich("Custom Sandwich", breadType, size, isToasted);
    }

}
