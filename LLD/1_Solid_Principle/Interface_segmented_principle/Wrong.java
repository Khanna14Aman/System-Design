// Interface Segregation Principle
// Interface should be such that, client should not implemnt the methods which are not applicable to them.

interface RestaurantEmployee {
    void takeOrder();
    void cookFood();
    void cleanDishes();
}

class Waiter implements RestaurantEmployee {
    @Override
    public void takeOrder() {
        System.out.println("Taking order from customer");
    }

    @Override
    public void cookFood() {
        // Not applicable for Waiter
        // So, we shouldn't implement this method.   
        throw new UnsupportedOperationException("Waiter doesn't cook food"); 
    }

    @Override
    public void cleanDishes() {
        // Not applicable for Waiter
        // So, we shouldn't implement this method.
        throw new UnsupportedOperationException("Waiter doesn't clean dishes");
    }
}

// This is wrong way to implement ISP.
// The Waiter class is forced to implement methods that are not applicable to it, such as cookFood() and cleanDishes().
// So, we should segregate the interface into two interfaces.

public class Wrong {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.takeOrder();
        // waiter.cookFood(); // Not applicable for Waiter
        // waiter.cleanDishes(); // Not applicable for Waiter
    }
}