package Abstract_Factory_Method;

public class OrderFood {
    public static void main(String [] args){
        MealFactory healthy = new HealthyCafe();
        MealFactory normal = new NormalCafe();

        Burger basicBurger = normal.createBurger("BasicBurger");
        basicBurger.prepare();

        Burger wheatPremiumBurger = healthy.createBurger("WheatPremiumBurger");
        wheatPremiumBurger.prepare();

        GarlicBread basicGarlicBread = normal.createGarlicBread("BasicGarlicBread");
        basicGarlicBread.prepare();

        GarlicBread wheatClassicGarlicBread = healthy.createGarlicBread("WheatClassicGarlicBread");
        wheatClassicGarlicBread.prepare();

    }
}
