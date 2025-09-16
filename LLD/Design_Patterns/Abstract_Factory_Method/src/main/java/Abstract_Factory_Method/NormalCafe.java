package Abstract_Factory_Method;

public class NormalCafe implements MealFactory{
    @Override
    public Burger createBurger(String type) {
        return switch (type){
            case "BasicBurger" -> new BasicBurger();
            case "ClassicBurger" -> new ClassicBurger();
            case "PremiumBurger" -> new PremiumBurger();
            default -> null;
        };
    }

    public GarlicBread createGarlicBread(String type){
        return switch (type){
            case "BasicGarlicBread" -> new BasicGarlicBread();
            case "ClassicGarlicBread" -> new ClassicGarlicBread();
            default -> null;
        };
    }
}
