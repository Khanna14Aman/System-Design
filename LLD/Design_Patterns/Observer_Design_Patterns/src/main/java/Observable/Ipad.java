package Observable;

import Observer.Observer;

import java.util.ArrayList;
import java.util.List;


public class Ipad implements ObservableItem {
    private List<Observer> observerList = new ArrayList<>();
    private int qty = 0;
    public void add(Observer obj){
        observerList.add(obj);
    }

    public void remove(Observer obj){
        observerList.remove(obj);
    }

    public void notifySubscribers(){
        for (Observer obj: observerList){
            obj.updateSubscribers();
        }
    }

    public void setData(int num){
        qty = num;
        notifySubscribers();
    }

    public int returnData(){
        return qty;
    }

}
