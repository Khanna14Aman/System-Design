package org.example;

public class ExtraCheese extends BasePizza{
    BasePizza base;
    public ExtraCheese(BasePizza obj){
        base = obj;
    }
    public int cost(){
        return base.cost() + 50;
    }
}
