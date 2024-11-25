package com.pluralsight.deli.service;

import com.pluralsight.deli.enums.BreadType;
import com.pluralsight.deli.enums.SandwichSize;
import com.pluralsight.deli.model.Sandwich;

public interface SandwichService {
    Sandwich createSandwich(String name, BreadType breadType, SandwichSize size, boolean isToasted);
}
