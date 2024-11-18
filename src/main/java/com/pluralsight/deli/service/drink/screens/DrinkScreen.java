package com.pluralsight.deli.service.drink.screens;

import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;

public class DrinkScreen{

    public static void drinkDisplay(Order order) {

        // Ask what kind of drink
        Drink.DrinkType drinkType = DrinkFlavorScreen.drinkFlavorDisplay(order);

        // Ask for size
        Drink.DrinkSize drinkSize = DrinkSizeScreen.drinkSizeDisplay(order);
        // Make Drink and add to Order
        Drink drink  = new Drink(drinkSize,drinkType);
        // add drink to order
        order.addProduct(drink);

    }
}
