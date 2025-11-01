package ZomatoLLD;

import java.util.List;

public class Main {
    public static void main(String [] args){
        Zomato zomato = new Zomato();
        User user = new User("Aman", "Kalyani Devi", "1234567890");
        System.out.println("New User "+user.getName()+" is active");

        List<Restaurant> restaurantList = zomato.findRestaurantByLocation("Denlhi");
        if(restaurantList.isEmpty()){
            System.out.println("No Restaurant Exist");
        }else{
            for(Restaurant restaurant: restaurantList){
                System.out.println("Name of restaurant: "+restaurant.getName());
                System.out.println("List of all the dishes inside this restaurant: ");
                for(Dish dish:restaurant.getDishList()){
                    System.out.println(dish.getName());
                }
            }
        }
        restaurantList = zomato.findRestaurantByName("Kanhashyam");
        if(restaurantList.isEmpty()){
            System.out.println("No Restaurant Exist");
        }else{
            for(Restaurant restaurant: restaurantList){
                System.out.println("Name of restaurant: "+restaurant.getName());
                System.out.println("List of all the dishes inside this restaurant: ");
                for(Dish dish:restaurant.getDishList()){
                    System.out.println(dish.getName());
                }
            }
        }
        zomato.displayUserCart(user);
        zomato.addDishToCart(user,restaurantList.get(0),restaurantList.get(0).getDishList().get(0));
        zomato.addDishToCart(user,restaurantList.get(0),restaurantList.get(0).getDishList().get(1));
        restaurantList = zomato.findRestaurantByName("restoblr");
        zomato.addDishToCart(user,restaurantList.get(0),restaurantList.get(0).getDishList().get(0));
        zomato.addDishToCart(user,restaurantList.get(0),restaurantList.get(0).getDishList().get(1));
        zomato.displayUserCart(user);
        Order order = zomato.checkOut(user,"Home Delivery");
        try {
            order.orderDetails();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        Payment finalPayment = zomato.completePayment(order,"card",user);
        try {
            finalPayment.paymentStatus();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
