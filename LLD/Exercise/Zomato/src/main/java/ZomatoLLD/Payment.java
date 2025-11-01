package ZomatoLLD;

public abstract class Payment {
    private static int id;
    protected String paymentMode;
    protected String userName;
    protected int totalCost;
    protected int paymentId;
    static{
        id = 1;
    }
    public Payment(String paymentMode,String userName,int totalCost){
        this.paymentId = id++;
        this.paymentMode = paymentMode;
        this.userName = userName;
        this.totalCost = totalCost;
    }
    public abstract void paymentStatus();

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getUserName() {
        return userName;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getPaymentId() {
        return paymentId;
    }
}
