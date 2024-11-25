package com.pluralsight.deli.service.sandwich.screens;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.service.HomeScreen;


import java.beans.Customizer;
import java.util.Scanner;

public class SandwichScreen{

    public void addSandwichDisplay(Order order) {


        // Asks what kind of breadtype
        Sandwich.BreadType breadType = SelectBreadTypeScreen.selectBreadType(order);
        // Asks for sandwich size
        Sandwich.SandwichSize sandwichSize = SelectSandwichSizeScreen.selectSandwichSize(order);
        // Asks for toasted or not
        boolean isToasted = ToastedScreen.selectToastedOption(order);
        // customization screen

        // Make sandwich and add to Order
        Sandwich sandwich = new Sandwich(breadType,sandwichSize, isToasted);


        // add drink to order
        order.addProduct(sandwich);
            }
        }

