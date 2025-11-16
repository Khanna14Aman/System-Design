package BridgeDesignPattern;

public class BridgeDesignPattern {
    public static void main(String[] args) {
        // Create Engine implementations
        Engine petrolEng = new PetrolEngine();
        Engine dieselEng = new DieselEngine();
        Engine electricEng = new ElectricEngine();

        // Create Car abstractions, injecting Engine implementations
        Car mySedan = new Sedan(petrolEng);
        Car mySUV = new SUV(electricEng);
        Car yourSUV = new SUV(dieselEng);

        // Use the cars
        mySedan.drive();   // Petrol engine + Sedan
        mySUV.drive();     // Electric engine + SUV
        yourSUV.drive();   // Diesel engine + SUV

        // No explicit cleanup needed in Java
    }
}
