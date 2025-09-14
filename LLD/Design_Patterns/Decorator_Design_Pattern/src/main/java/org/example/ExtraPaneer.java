package org.example;

public class ExtraPaneer extends BasePizza{
    BasePizza base;
    public ExtraPaneer(BasePizza obj){
        base = obj;
    }
    public int cost(){
        return base.cost() + 50;
    }
}
