package ZomatoLLD;

public class CardPayment extends Payment {
    public CardPayment(String paymentMode, String userName, int totalCost){
        super(paymentMode,userName,totalCost);
    }
    public void paymentStatus() {
        System.out.println("Dear " + this.userName + " your UPI payment of " + this.totalCost + " is successfully done through " + this.paymentMode);
    }
}
