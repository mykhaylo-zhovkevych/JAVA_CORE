package com.patterns;


public class PizzaShop {

    public static void main(String[] args) {

        Pizza plainPizza = new PlainPizza();
        System.out.println("Ordering a plain pizza:");
        System.out.println("Description:" + plainPizza.getDescription());
        System.out.println("Cost:" + plainPizza.getCost());


        Pizza myOrder = new PlainPizza();

        myOrder = new Cheese(myOrder);

        myOrder = new Pepperoni(myOrder);
        
        myOrder = new Cheese(myOrder);

        System.out.println("Ordering a fully loaded pizza:");
        System.out.println("Description:" + myOrder.getDescription());
        System.out.println("Cost:" + myOrder.getCost());

    }
}