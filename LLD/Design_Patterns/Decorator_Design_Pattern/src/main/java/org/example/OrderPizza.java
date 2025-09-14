package org.example;

public class OrderPizza {
    public static void main(String [] args){
        BasePizza extraCheese = new ExtraCheese(new ExtraPaneer(new Classic()));
        System.out.println(extraCheese.cost());
        System.out.println(new Classic().cost());
    }
}

// Decorator Design Pattern is used to overcome the problem of Class explosion.
