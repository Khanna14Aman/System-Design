package ZomatoLLD;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static final RestaurantManager instance;
    static {
        instance = new RestaurantManager();
    }
    private List<Restaurant> restaurantList;
    private RestaurantManager(){
        restaurantList = new ArrayList<>();
    }
    public static RestaurantManager getInstance(){
        return instance;
    }
    public List<Restaurant> findRestaurantByLocation(String location){
        List<Restaurant> searchRestaurant = new ArrayList<>();
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getLocation().equalsIgnoreCase(location)){
                searchRestaurant.add(restaurant);
            }
        }
        return searchRestaurant;
    }
    public List<Restaurant> findRestaurantByName(String name){
        List<Restaurant> searchRestaurant = new ArrayList<>();
        for(Restaurant restaurant: restaurantList){
            if(restaurant.getName().equalsIgnoreCase(name)){
                searchRestaurant.add(restaurant);
            }
        }
        return searchRestaurant;
    }
    public void addRestaurant(String name, String location){
        restaurantList.add(new Restaurant(location,name));
    }
    public void addDish(Restaurant restaurant,String name){
        restaurant.addDish(new Dish(name,100,"200ml"));
    }
}
