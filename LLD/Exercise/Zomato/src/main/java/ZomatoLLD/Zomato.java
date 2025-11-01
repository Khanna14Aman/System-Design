package ZomatoLLD;

import java.util.List;

public class Zomato {
    public Zomato(){
        initializeApp();
    }
    private RestaurantManager restaurantManager = RestaurantManager.getInstance();
    private void initializeApp(){
        restaurantManager.addRestaurant("UP70","Allahabad");
        restaurantManager.addRestaurant("KanhaShyam","Delhi");
        restaurantManager.addRestaurant("RestoBLR","Bangalore");
        List<Restaurant> restaurantList = restaurantManager.findRestaurantByName("UP70");
        restaurantManager.addDish(restaurantList.get(0),"Aloo paratha");
        restaurantManager.addDish(restaurantList.get(0),"Maggie");
        restaurantList = restaurantManager.findRestaurantByName("kanhashyam");
        restaurantManager.addDish(restaurantList.get(0),"MOMO");
        restaurantManager.addDish(restaurantList.get(0),"Spring roll");
        restaurantList = restaurantManager.findRestaurantByName("restoblr");
        restaurantManager.addDish(restaurantList.get(0),"DOSA");
        restaurantManager.addDish(restaurantList.get(0),"IDLI");
    }
    public List<Restaurant> findRestaurantByLocation(String location){
        return restaurantManager.findRestaurantByLocation(location);
    }
    public List<Restaurant> findRestaurantByName(String name){
        return restaurantManager.findRestaurantByName(name);
    }

    public void addDishToCart(User user, Restaurant restaurant, Dish dish){
        user.getCart().addItem(restaurant,dish);
    }
    public void displayUserCart(User user){
        Cart cart = user.getCart();
        if(cart.getItems().isEmpty())return;
        for(Restaurant restaurant: cart.getItems().keySet()){
            System.out.println("From Restaurant "+restaurant.getName()+" below foods have been added in Cart:");
            for(Dish dish: cart.getItems().get(restaurant)){
                System.out.println("Dish Name: "+dish.getName());
            }
        }
        System.out.println("Total Cost of Cart is "+cart.getTotalCost());
    }

    public Order checkOut(User user, String ordertype){
        return FactoryDelivery.createOrder(user,ordertype);
    }
    public Payment completePayment(Order order, String paymentMode,User user){
        Payment payment = FactoryPayment.completePayment(paymentMode, order.getUserName(), order.totalCost);
        if(payment != null){
            user.getCart().getItems().clear();
        }
        return payment;
    }
}
