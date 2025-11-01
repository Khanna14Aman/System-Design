package ZomatoLLD;

public class FactoryPayment {
    public static Payment completePayment(String paymentMode, String userName, int totalCost){
        if(paymentMode.equalsIgnoreCase("upi")){
            return new UPIPayment(paymentMode,userName,totalCost);
        }else if(paymentMode.equalsIgnoreCase("card")){
            return new CardPayment(paymentMode,userName,totalCost);
        }
        return null;
    }
}
