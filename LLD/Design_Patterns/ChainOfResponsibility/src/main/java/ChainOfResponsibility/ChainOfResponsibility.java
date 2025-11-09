package ChainOfResponsibility;

public class ChainOfResponsibility {
    public static void main(String [] args){
        MoneyHandler thousandHandler = new ThousandHandler(3);
        MoneyHandler fiveHundredHandler = new FiveHundredHandler(5);
        MoneyHandler twoHundredHandler = new TwoHundredHandler(10);
        MoneyHandler hundredHandler = new HundredHandler(20);

        thousandHandler.setNextHandler(fiveHundredHandler);
        fiveHundredHandler.setNextHandler(twoHundredHandler);
        twoHundredHandler.setNextHandler(hundredHandler);

        int amountToWithdraw = 4300;

        System.out.println("\nDispensing amount: ₹" + amountToWithdraw);
        thousandHandler.dispense(amountToWithdraw);
    }
}
