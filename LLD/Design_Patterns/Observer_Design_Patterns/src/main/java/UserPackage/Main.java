package UserPackage;
import Observable.Ipad;
import Observable.Iphone;
import Observable.ObservableItem;
import Observer.*;

public class Main {
    public static void main(String [] Args){
        ObservableItem iphone1 = new Iphone();
        Observer emailUser = new Email(iphone1);
        System.out.println(iphone1.returnData());
        iphone1.setData(3);
        System.out.println(iphone1.returnData());
        iphone1.add(emailUser);
        Observer phone = new Phone(iphone1);
        iphone1.add(phone);
        iphone1.setData(3);
        iphone1.setData(0);
        ObservableItem ipad1 = new Ipad();
        ipad1.setData(3);
    }

}
