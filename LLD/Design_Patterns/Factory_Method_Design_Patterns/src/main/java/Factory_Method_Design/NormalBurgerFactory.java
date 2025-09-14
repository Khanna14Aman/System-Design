package Factory_Method_Design;

public class NormalBurgerFactory implements Factories{
    public Burger createBurger(String name){
        return switch (name) {
            case "BasicBurger" -> new BasicBurger();
            case "ClassicBurger" -> new ClassicBurger();
            case "PremiumBurger" -> new PremiumBurger();
            default -> null;
        };
    }
}
