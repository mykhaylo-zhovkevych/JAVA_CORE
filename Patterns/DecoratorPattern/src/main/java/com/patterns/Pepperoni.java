package com.patterns;

/**
 * Another Concrete Decorator
 * 
 */
public class Pepperoni extends ToppingDecorator {

    public Pepperoni(Pizza pizza) {
        super(pizza); // Pass the pizza to the parent decorator
    }

    
    @Override
    public String getDescription() {
        return wrappedPizza.getDescription() + ", with pepperoni";
    }

    
    @Override
    public double getCost() {
        return wrappedPizza.getCost() + 2.25; 
    }
}