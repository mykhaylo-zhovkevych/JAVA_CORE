package com.unit.test;

public class Main {
    public static void main(String[] args) {
    	
    	int firstInt = 7;
    	int secoundInt = 8;
    	
    	int sum = add(firstInt, secoundInt);
    	
        System.out.println("The sum is: " + sum);
        
    }
    
    private static int add(int int1, int int2) {
    	int sum = int1 + int2;
    	return sum;
    }
}