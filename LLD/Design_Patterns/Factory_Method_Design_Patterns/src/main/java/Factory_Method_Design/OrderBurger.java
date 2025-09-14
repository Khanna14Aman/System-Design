package Factory_Method_Design;

public class OrderBurger {
    public static void main(String [] args){
        Factories normalBurger = new NormalBurgerFactory();
        Factories healthyBurger = new HealthyBurgerFactory();
        Burger basicBurger = normalBurger.createBurger("BasicBurger");
        try {
            basicBurger.prepare();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        Burger wheatBasicBurger = healthyBurger.createBurger("WheatBasicBurger");
        try{
            wheatBasicBurger.prepare();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}