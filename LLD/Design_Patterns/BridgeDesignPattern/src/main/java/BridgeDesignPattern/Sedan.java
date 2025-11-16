package BridgeDesignPattern;

public class Sedan extends Car{
    public Sedan(Engine e) {
        super(e);
    }

    @Override
    public void drive() {
        engine.start();
        System.out.println("Driving a Sedan on the highway.");
    }
}
