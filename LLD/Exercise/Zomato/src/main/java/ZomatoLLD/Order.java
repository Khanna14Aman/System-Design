package ZomatoLLD;

import java.util.List;
import java.util.Map;

public abstract class Order {
    private static int id;
    protected int orderID;
    protected String userName;
    protected String address;
    protected String orderType;
    protected Map<Restaurant,List<Dish>> items;
    protected int totalCost;
    static{
        id = 1;
    }
    public Order(String userName, String address, String orderType, Map<Restaurant,List<Dish>> items, int totalCost){
        this.orderID = id++;
        this.address = address;
        this.orderType = orderType;
        this.userName = userName;
        this.items = items;
        this.totalCost = totalCost;
    }
    public abstract void orderDetails();

    public int getOrderID() {
        return orderID;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public String getOrderType() {
        return orderType;
    }

    public Map<Restaurant, List<Dish>> getItems() {
        return items;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
