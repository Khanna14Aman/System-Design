package Abstract_Factory_Method;

public interface MealFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}
