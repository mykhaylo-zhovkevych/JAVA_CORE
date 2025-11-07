package com.patterns;
/**
 * A Concrete Decorator
 * 
 */
public class Cheese extends ToppingDecorator {

    public Cheese(Pizza pizza) {
        // Pass the pizza to the parent decorator
        super(pizza); 
    }

    
    @Override
    public String getDescription() {
        return wrappedPizza.getDescription() + ", with extra cheese";
    }

  
    @Override
    public double getCost() {
        return wrappedPizza.getCost() + 1.50; 
    }
}