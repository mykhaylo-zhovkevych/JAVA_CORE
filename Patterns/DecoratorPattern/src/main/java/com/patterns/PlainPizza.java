package com.patterns;

/*
 * The Concrete Component
 */

public class PlainPizza implements Pizza {
    
    @Override
    public String getDescription() {
        return "Plain Pizza some description";
    }

    @Override
    public double getCost() {
        return 5.00;
    }

}
