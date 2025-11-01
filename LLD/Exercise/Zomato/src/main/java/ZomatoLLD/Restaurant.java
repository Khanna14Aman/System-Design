package ZomatoLLD;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int id;
    static{
        id = 1;
    }
    private int restaurantId;
    private String name;
    private String location;
    private List<Dish> dishList = new ArrayList<>();
    public Restaurant(String location, String name) {
        this.location = location;
        this.name = name;
        restaurantId = id++;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public List<Dish> getDishList() {
        return dishList;
    }
    public void addDish(Dish dish) {
        this.dishList.add(dish);
    }
}
