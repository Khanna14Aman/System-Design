interface WaiterInterface {
    void takeOrder();
    void serveFood();
}

interface CookInterface {
    void cookFood();
    void decideMenu();
}

class Waiter implements WaiterInterface {
    @Override
    public void takeOrder() {
        System.out.println("Taking order from customer");
    }

    @Override
    public void serveFood() {
        System.out.println("Serving food to customer");
    }
}

class Cook implements CookInterface {
    @Override
    public void cookFood() {
        System.out.println("Cooking food");
    }

    @Override
    public void decideMenu() {
        System.out.println("Deciding menu for the day");
    }
}

public class Right {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.takeOrder();
        waiter.serveFood();

        Cook cook = new Cook();
        cook.cookFood();
        cook.decideMenu();
    }
}