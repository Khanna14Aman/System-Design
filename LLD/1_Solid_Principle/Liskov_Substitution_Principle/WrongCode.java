// Liskov Substitution Principle
// The Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

import java.util.ArrayList;
import java.util.List;

class vehicle {
    public int numberOfWheels() {
        return 2;
    }
    public String engineType() {
        return "Bike";
    }
}

class bike extends vehicle {

}

class car extends vehicle {
    public int numberOfWheels() {
        return 4;
    }
    @Override
    public String engineType() {
        return "Car";
    }
}

class bicycle extends vehicle {
    public int numberOfWheels() {
        return 2;
    }
    @Override
    public String engineType() {
        return null; // This violates LSP as it returns null instead of a valid engine type
    }
}

public class WrongCode {
    public static void main(String[] args) {
        List<vehicle> V = new ArrayList<>();
        vehicle v2 = new car();
        vehicle v1 = new bike();
        vehicle v3 = new bicycle(); // This violates LSP as it does not provide a valid engine type
        V.add(v1);
        V.add(v2);
        V.add(v3);
        // This will cause a NullPointerException when calling engineType() on bicycle
        for (vehicle v : V) {
            System.out.println(v.numberOfWheels());
            System.out.println(v.engineType().toString());
        }
    }
}
// In this example, the bicycle class violates the Liskov Substitution Principle because it returns null for the engineType method, which is not a valid behavior for a vehicle.
// To fix this, we can either provide a valid engine type for the bicycle class or remove the engineType method from the vehicle class and create a separate interface for vehicles with engines.