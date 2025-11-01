package ZomatoLLD;

public class FactoryDelivery {
    public static Order createOrder(User user, String orderType){
        if (orderType.equals("Home Delivery")) {
            return new DeliveryOrder("Home Delivery", user.getName(), user.getAddress(), user.getCart().getItems(), user.getCart().getTotalCost());
        }else if(orderType.equals("PickUp Order")){
            return new PickUpOrder(orderType,user.getName(),"Zomato Office",user.getCart().getItems(),user.getCart().getTotalCost());
        }
        return null;
    }
}
