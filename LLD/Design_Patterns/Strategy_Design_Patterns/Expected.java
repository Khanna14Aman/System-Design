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



class RollsRoyce {
    private EngineType engineType;
    public RollsRoyce(EngineType engineType) {
        this.engineType = engineType;
    }
    public void engineType() {
        engineType.engineType();
    }
}

class Lamborghini {
    private EngineType engineType;
    public Lamborghini(EngineType engineType) {
        this.engineType = engineType;
    }
    public void engineType() {
        engineType.engineType();
    }
}

class Ferrari{
    private EngineType engineType;
    public Ferrari(EngineType engineType) {
        this.engineType = engineType;
    }
    public void engineType() {
        engineType.engineType();
    }
}

class NormalCar{
    private EngineType engineType;
    public NormalCar(EngineType engineType) {
        this.engineType = engineType;
    }
    public void engineType() {
        engineType.engineType();
    }
}

class Expected {
    public static void main(String[] args) {
        EngineType normalEngine = new NormalEngine();
        EngineType luxuriousEngine = new LuxuriousEngine();
        EngineType superAdvancedEngine = new SuperAdvancedEngine();

        RollsRoyce rollsRoyce = new RollsRoyce(luxuriousEngine);    
        Lamborghini lamborghini = new Lamborghini(superAdvancedEngine);
        Ferrari ferrari = new Ferrari(superAdvancedEngine);
        NormalCar normalCar = new NormalCar(normalEngine);
        rollsRoyce.engineType();
        lamborghini.engineType();   
        ferrari.engineType();
        normalCar.engineType();

    }
}

// Compare this snippet from LLD/Design_Patterns/Strategy_Design_Patterns/Right.java:
// Here we remove the Car class and directly use the car classes (RollsRoyce, Lamborghini, Ferrari, NormalCar) to show the engine type.
// But here we creating code duplication in each class like RollsRoyce, Lamborghini, Ferrari, NormalCar.
// So this is why we need to use Car class to remove the code duplication.