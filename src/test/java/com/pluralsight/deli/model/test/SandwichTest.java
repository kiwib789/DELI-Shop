package com.pluralsight.deli.model.test;

import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.PremiumToppings;
import com.pluralsight.deli.model.enums.RegularToppings;
import com.pluralsight.deli.model.enums.SandwichSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SandwichTest {

    @Test
    void getPrice_Medium_Sandwich_With_One_Meat_Topping_Costs_Nine(){
       double expectedPrice = 9.00;
        // Arrange
        Sandwich s = new Sandwich("Roast beef sub", BreadType.WHEAT, SandwichSize.MEDIUM,true  );
        s.addRegularTopping(RegularToppings.LETTUCE);
        s.addRegularTopping(RegularToppings.TOMATOES);
        s.addPremiumTopping((PremiumToppings.ROAST_BEEF));
        // Act
        double actualPrice = s.getPrice();
        // Assert
       assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void getPrice_Medium_Sandwich_With_One_Meat_And_One_Cheese(){
        double expectedPrice = 10.50;
        // Arrange
        Sandwich s = new Sandwich("Roast beef sub", BreadType.WHEAT, SandwichSize.MEDIUM,true  );
        s.addRegularTopping(RegularToppings.LETTUCE);
        s.addRegularTopping(RegularToppings.TOMATOES);
        s.addPremiumTopping((PremiumToppings.ROAST_BEEF));
        s.addPremiumTopping((PremiumToppings.CHEDDAR_CHEESE));
        // Act
        double actualPrice = s.getPrice();
        // Assert
        assertEquals(expectedPrice, actualPrice);
    }

}
