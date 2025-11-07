package com.patterns;

public interface Pizza {
    
    /**
     * The Component Interface
     * Defines the methods that will be implemenmted by the concrete component and decorators
     */
    String getDescription();
    double getCost();
}
