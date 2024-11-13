package com.pluralsight.deli.model.test;

import com.pluralsight.deli.model.Sandwich;
import com.pluralsight.deli.model.enums.BreadType;
import com.pluralsight.deli.model.enums.SandwichSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SandwichTest {
    Sandwich sandwich;

    @BeforeEach
    void setUp() {
        sandwich = new Sandwich("Sandwich1", BreadType.WHEAT, SandwichSize.MEDIUM, true);

    }

    @Test
    void createSandwichTest(){
        assert(sandwich.getName().equals("Sandwich1") );
        assertTrue(sandwich.isToasted) // would pass need getter for isToasted
    }



}
