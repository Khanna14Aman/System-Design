package BridgeDesignPattern;

public class SUV extends Car{
    public SUV(Engine e) {
        super(e);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving an SUV off-road.");
    }
}
