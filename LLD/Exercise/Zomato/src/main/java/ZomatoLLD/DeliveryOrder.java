package ZomatoLLD;

import java.util.List;
import java.util.Map;

public class DeliveryOrder extends Order{

    public DeliveryOrder(String orderType, String userName, String address,Map<Restaurant,List<Dish>> items, int totalCost){
        super(userName,address,orderType,items,totalCost);
    }
    @Override
    public void orderDetails() {
        System.out.println("Dear "+this.getUserName()+ " your order number: "+this.getOrderID()+" is ready for "+this.getOrderType()+" at "+this.getAddress());
        System.out.println("Your order details are given below:");
        for(Restaurant restaurant: this.getItems().keySet()){
            System.out.println("Dishes from restaurant "+restaurant.getName());
            for(Dish dish: this.getItems().get(restaurant)){
                System.out.println(dish.getName());
            }
        }
        System.out.println("Total cost for whole order is "+this.getTotalCost());
    }
}
