package ZomatoLLD;

public class CardPayment extends Payment {
    public CardPayment(String paymentMode, String userName, int totalCost){
        super(paymentMode,userName,totalCost);
    }
    public void paymentStatus() {
        System.out.println("Dear " + this.getUserName() + " your UPI payment of " + this.getTotalCost() + " is successfully done through " + this.getPaymentMode()+" with payment ID: "+this.getPaymentId());
    }
}
