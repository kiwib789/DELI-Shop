package com.pluralsight.deli.model;

import com.pluralsight.deli.model.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product{
    private BreadType breadType;
    private SandwichSize size;
    private boolean isToasted;
    private List<RegularToppings> regularToppings;
    private List<PremiumToppings> premiumToppings;

    public Sandwich(String name, BreadType breadType, SandwichSize size, boolean isToasted) {
        super(name, 0);
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }


    @Override
    public double getPrice() {
        for (PremiumToppings toppings : premiumToppings ){
            if(toppings.getType()== PremiumToppings.Type.MEAT){
                if (size == SandwichSize.SMALL){
                     += 1.00;
                }
            }

        }
        // need to calculate price based on topping type bread type conditional statements
        //look through premium topping (for loop) list
        // if premium topping is cheese create appropriate pay scale
        // if meat create appropriate pay scale
        return 0;
    }
}
//
