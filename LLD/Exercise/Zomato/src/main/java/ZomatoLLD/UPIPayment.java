package ZomatoLLD;

public class UPIPayment extends Payment{
    public UPIPayment(String paymentMode,String userName,int totalCost){
        super(paymentMode,userName,totalCost);
    }
    @Override
    public void paymentStatus() {
        System.out.println("Dear "+this.getUserName()+" your UPI payment of "+this.getTotalCost()+" is successfully done through "+this.getPaymentMode()+"with payment ID: "+this.getPaymentId());
    }
}
