
import java.util.ArrayList;
import java.util.List;

interface Vehicle {
    public int numberOfWheels();
}

class EngineVehicle implements Vehicle {
    public int numberOfWheels() {
        return 2;
    }

    public String engineType() {
        return "Bike";
    }
}

class Bike extends EngineVehicle {
}
class Car extends EngineVehicle {
    public int numberOfWheels() {
        return 4;
    }

    @Override
    public String engineType() {
        return "Car";
    }
}

class Bicycle implements Vehicle {
    public int numberOfWheels() {
        return 2;
    }
}
public class RightCode {
    public static void main(String[] args) {
        List<Vehicle> V = new ArrayList<>();
        Vehicle v2 = new Car();
        Vehicle v1 = new Bike();
        Vehicle v3 = new Bicycle();
        V.add(v1);
        V.add(v2);
        V.add(v3);
        for (Vehicle v : V) {
            System.out.println(v.numberOfWheels()); // This will not cause a NullPointerException

        }
        // The engineType method is not called on the Bicycle object, so it does not violate LSP
        for (Vehicle v : V){
            System.out.println(v.engineType().toString()); // This gives compile time error so our code will not break in production.
        }
    }
}
