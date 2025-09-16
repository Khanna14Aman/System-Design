package Abstract_Factory_Method;

public class HealthyCafe implements MealFactory{
    public Burger createBurger(String type){
        return switch (type) {
            case "WheatBasicBurger" -> new WheatBasicBurger();
            case "WheatClassicBurger" -> new WheatClassicBuger();
            case "WheatPremiumBurger" -> new WheatPremiumBurger();
            default -> null;
        };
    }
    public GarlicBread createGarlicBread(String type){
        return switch (type){
            case "WheatBasicGarlicBread" -> new WheatBasicGarlicBread();
            case "WheatClassicGarlicBread" -> new WheatClassicGarlicBread();
            default -> null;
        };
    }
}
