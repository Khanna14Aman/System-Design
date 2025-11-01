package ZomatoLLD;

public class Dish {
    private static int id;
    static{
        id = 1;
    }
    private int dishId;
    private String name;
    private int price;
    private String qty;
    public Dish(String name, int price, String qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        dishId = id++;
    }

    public int getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }
}
