interface EngineType {
    void engineType();
}

class NormalEngine implements EngineType {
    public void engineType() {
        System.out.println("Normal Engine");
    }
}

class LuxuriousEngine implements EngineType {
    public void engineType() {
        System.out.println("Luxurious Engine");
    }
}

class SuperAdvancedEngine implements EngineType {
    public void engineType() {
        System.out.println("Super Advanced Engine");
    }
}

class Car {
    private EngineType engineType;

    public Car(EngineType engineType) {
        this.engineType = engineType;
    }

    public void showEngineType() {
        System.out.print("Car with ");
        engineType.engineType();
    }
}

class RollsRoyce extends Car {
    public RollsRoyce(EngineType engineType) {
        super(engineType);
    }
}

class Lamborghini extends Car {
    public Lamborghini(EngineType engineType) {
        super(engineType);
    }
}

class Ferrari extends Car {
    public Ferrari(EngineType engineType) {
        super(engineType);
    }
}

class NormalCar extends Car {
    public NormalCar(EngineType engineType) {
        super(engineType);
    }
}

class Right {
    public static void main(String[] args) {
        EngineType normalEngine = new NormalEngine();
        EngineType luxuriousEngine = new LuxuriousEngine();
        EngineType superAdvancedEngine = new SuperAdvancedEngine();

        Car car1 = new NormalCar(normalEngine);
        car1.showEngineType();

        Car car2 = new RollsRoyce(luxuriousEngine);
        car2.showEngineType();

        Car car3 = new Lamborghini(superAdvancedEngine);
        car3.showEngineType();

        Car car4 = new Ferrari(superAdvancedEngine);
        car4.showEngineType();
    }
}

// The code demonstrates the correct implementation of the Strategy Design Pattern.
// The code is flexible and allows for easy addition of new engine types.
// The code is easy to maintain and extend in the future.
// It might comes in mind that why we have created a class Car and then extending it to NormalCar, RollsRoyce, Lamborghini and Ferrari. Why not just extends NormalEngine, LuxuriousEngine, SuperAdvancedEngine to each of the car classes.
// The reason is that if we don't use car class then for every car we have to define engine type in the class itself. And that will lead to code duplication. Because we have to write the same code for defining engine type in every car class.