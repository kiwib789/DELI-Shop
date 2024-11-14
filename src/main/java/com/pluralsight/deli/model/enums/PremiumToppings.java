package com.pluralsight.deli.model.enums;

public enum PremiumToppings {
    // All the meat toppings
    STEAK(Type.MEAT),
    HAM(Type.MEAT),
    SALAMI(Type.MEAT),
    ROAST_BEEF(Type.MEAT),
    CHICKEN(Type.MEAT),
    BACON(Type.MEAT),

    // All the cheese toppings
    AMERICAN_CHEESE(Type.CHEESE),
    SWISS_CHEESE(Type.CHEESE),
    PROVOLONE_CHEESE(Type.CHEESE),
    CHEDDAR_CHEESE(Type.CHEESE);

    private final Type type;

    public Type getType(){
        return type;
    }
    PremiumToppings(Type type) {
        this.type = type;
    }
    public enum Type{
        MEAT,
        CHEESE;
    }
}
