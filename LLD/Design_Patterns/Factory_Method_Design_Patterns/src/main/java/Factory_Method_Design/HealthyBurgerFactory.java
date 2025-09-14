package Factory_Method_Design;

public class HealthyBurgerFactory implements Factories{
    public Burger createBurger(String name){
        return switch (name){
            case "WheatBasicBurger" -> new WheatBasicBurger();
            case "WheatClassicBurger" -> new WheatClassicBurger();
            case "WheatPremiumBurger" -> new WheatPremiumBurger();
            default -> null;
        };
    }
}
