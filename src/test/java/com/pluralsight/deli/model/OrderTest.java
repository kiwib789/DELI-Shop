package com.pluralsight.deli.model;

import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.SandwichSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getPrice() {
        // Arrange
        // create and order and add two sandwiches
        double expectedPrice = 11;
        // act
        Order o = new Order();
        o.addProduct(new Sandwich("Empty", BreadType.WHITE, SandwichSize.SMALL, false));
        o.addProduct(new Sandwich("Empty", BreadType.WHITE, SandwichSize.SMALL, false));
        double actualPrice = o.getPrice();
        // assert
        assertEquals(expectedPrice, actualPrice);
    }
}