// The code demonstrates the wrong implementation of the Strategy Design Pattern.
// The code is not following the principles of the Strategy Design Pattern.
// The code is not flexible and does not allow for easy addition of new engine types.

class EngineType{
    public void EngintType(){
        System.out.println("Normal Engine");
    }
}

class NormalCar extends EngineType{
}

class RollsRoyce extends EngineType{
    public void EngintType(){
        System.out.println("Luxurious Engine");
    }
}

class Lamborghini extends EngineType{
    public void EngintType(){
        System.out.println("Super Advanced Engine");
    }
}

class Ferrari extends EngineType{
    public void EngintType(){
        System.out.println("Super Advanced Engine");
    }
}


public class Wrong {
    public static void main(String[] args) {
        EngineType car1 = new NormalCar();
        car1.EngintType();

        EngineType car2 = new RollsRoyce();
        car2.EngintType();

        // Lamborghini and Ferrari have the same engine type
        // but they are implemented in different classes. In future if we want to add new car with different engine type than Base class but same as Lamborghini and Ferrari
        // then we have to create a new class and duplicate the code.
        EngineType car3 = new Lamborghini();
        car3.EngintType();

        EngineType car4 = new Ferrari();
        car4.EngintType();
    }    
}
// It will be difficult to maintain and extend in the future and will lead to code duplication as class Lamborghini and Ferrari have the same engine type and creating duplicate code.