package ZomatoLLD;

public class UPIPayment extends Payment{
    public UPIPayment(String paymentMode,String userName,int totalCost){
        super(paymentMode,userName,totalCost);
    }
    @Override
    public void paymentStatus() {
        System.out.println("Dear "+this.userName+" your UPI payment of "+this.totalCost+" is successfully done through "+this.paymentMode);
    }
}
