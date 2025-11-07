package com.patterns;
/**
 * This reference is dynamically set at runtime
 */
public abstract class ToppingDecorator implements Pizza {
    
    protected Pizza wrappedPizza;
    
    public ToppingDecorator(Pizza pizza) {
        this.wrappedPizza = pizza;
    }

    @Override
    public String getDescription() {
        return wrappedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedPizza.getCost();
    }
}