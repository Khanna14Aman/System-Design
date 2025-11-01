package ZomatoLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Restaurant, List<Dish>> items = new HashMap<>();
    private int totalCost;
    private void setTotalCost(int cost){
        totalCost += cost;
    }
    public int getTotalCost(){
        return totalCost;
    }
    public void addItem(Restaurant restaurant,Dish dish){
        if(items.containsKey(restaurant)) {
            List<Dish> temp = items.get(restaurant);
            temp.add(dish);
            items.put(restaurant, temp);
        }else{
            List<Dish> temp = new ArrayList<>();
            temp.add(dish);
            items.put(restaurant,temp);
        }
        setTotalCost(dish.getPrice());
    }
    public Map<Restaurant,List<Dish>> getItems(){
        return items;
    }
}
