package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.model.Chips;
import com.pluralsight.deli.model.Drink;
import com.pluralsight.deli.model.Order;
import com.pluralsight.deli.model.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Order order;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public UserInterface(Order order) {
        this.order = order;
    }
    // home screen








    // user selects  size of sandwich





    // user chooses regular toppings














    public void addExtraMeatDisplay() {
        boolean isRunning = true;
        while (isRunning) {

        }
        return;
    }

    // user chooses if they want the bread toasted










    public void checkOutDisplay() {
        boolean isRunning = true;
        while (isRunning) {
            // get users name

        }
    }


















        public List<Sandwich> getSandwiches () {
            return sandwiches;
        }

        public void setSandwiches (List < Sandwich > sandwiches) {
            this.sandwiches = sandwiches;
        }

        public Order getOrder () {
            return order;
        }

        public void setOrder (Order order){
            this.order = order;
        }

        public List<Drink> getDrinks () {
            return drinks;
        }

        public void setDrinks (List < Drink > drinks) {
            this.drinks = drinks;
        }

        public List<Chips> getChips () {
            return chips;
        }

        public void setChips (List < Chips > chips) {
            this.chips = chips;
        }
    }


